package com.projeto;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Out;
import edu.princeton.cs.algs4.StdOut;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.util.*;

import static com.projeto.DataBase.bst;
import static com.projeto.DataBase.edges;


public class Main {

    static DataBase dataBase = new DataBase();

    public static void main(String[] args) {
        loadFiles();
        now();
        Date d = new Date(17, 11, 2032);
        dataBase.tagFound("crossing");
        dataBase.top5Users(d);
        dataBase.top5PoIs(d);
        dataBase.notVisitedPoI(d);
        loadToFiles();
        dataBase.maxFlowFrom2Nodes();
        Coordinate c = new Coordinate(39,40);
        dataBase.searchTagNearCoordinate(c);
        System.out.println(dataBase.searchTagWays("highway"));
        System.out.println(dataBase.searchTagNodes("crossing"));
        dataBase.newTagValue();
    }

    /**
     * Prints all database on the instant of the calling method
     */
    static Date d = new Date(29, 4, 2022);

    private static void now() {
        Date d2 = new Date(29, 4, 2022);
        dataBase.printUserList();
        dataBase.printEdges();
        dataBase.printHash();
        dataBase.tagFound("crossing");
        //dataBase.top5PoIs(d);
        //dataBase.top5Users(d);
        dataBase.notVisitedPoI(d);
        dataBase.addEdges();
        dataBase.overPopulatedNode(d2);
    }


    private static void loadToFiles() {
        String fileSource1 = "data\\overpopulated_nodes_file_txt.txt";
        String fileSource2 = "data\\graph_file_txt.txt";
        String fileSource3 = "data\\nodes_visit_file_txt.txt";
        String fileSource4 = "data\\top5s_file_txt.txt";
        String fileSource5 = "data\\overpopulated_nodes.bin";
        String fileSource6 = "data\\graph_file_bin.bin";
        String fileSource7 = "data\\nodes_visit_file_bin.bin";
        String fileSource8 = "data\\top5s_file_bin.bin";
        loadOverpopulatedNodesToFile(fileSource1, 19, 22);
        loadGraphToFile(fileSource2);
        loadNodesVisitToFile(fileSource3);
        loadTop5sToFile(fileSource4);
        /*loadOverpopulatedNodesToBin(fileSource5, 19, 22);
        loadGraphToBin(fileSource6);
        loadNodesVisitToBin(fileSource7);
        loadTop5sToBin(fileSource8);*/
    }

    public static void loadOverpopulatedNodesToFile(String path, int from, int to) {
        Out out = new Out(path);
        Iterator<Nodes> itr = dataBase.set.iterator();
        out.println("At this date: " + d.toString() + " there were these overpopulated nodes:");
        while (itr.hasNext()) {
            Nodes node = (Nodes) itr.next();
            out.println("-Node id: " + node.getId());
        }
        dataBase.shortestPathNotOverpopulated(from, to);
        out.println();
        if (dataBase.sp.hasPathTo(to)) {
            out.println(dataBase.sp.pathTo(to));
            out.println("Shortest non overpopulated path from vertex " + from + " to vertex " + to + " is " + dataBase.sp.distTo(to));
        } else {
            out.println("There's no such path or there's no non overpopulated route.");
        }

        out.println();
        dataBase.shortestPath(from, to);

        if (dataBase.sp.hasPathTo(to)) {
            out.println(dataBase.sp.pathTo(to));
            out.println("Shortest path from vertex " + from + " to vertex " + to + " is " + dataBase.sp.distTo(to));
        } else {
            out.println("There's no such path.");
        }
    }

    public static void loadGraphToFile(String path) {
        Out out = new Out(path);
        out.println("Check graph connectivity data:");
        if (dataBase.checkConnectivity() == 0) {
            out.println("The graph is connected.");
        } else {
            out.println("The graph isn't connected.");
        }
        out.println();
        out.println("Check subgraph connectivity data:");

        if (dataBase.checkSubGraphConnectivity() == 0) {
            out.println("The subgraph is connected.");
        } else {
            out.println("The subgrap isn't connected.");
        }
    }

    public static void loadNodesVisitToFile(String path) {
        Out out = new Out(path);
        ArrayList<PoI> visitedPoI = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();

        out.println("At this date: " + d + " these points of interest were visited by a user:");
        for (User user : dataBase.users) {
            visitedPoI = dataBase.visitedBy(d, user);
            out.println("-" + user.getName());
            for (PoI poI : visitedPoI) {
                out.println("---PoI name: " + poI.getName());
            }
        }
        out.println("At this date: " + d + " these points of interest were not visited by any user:");
        Set<String> notVisited = new HashSet<>();
        for (User user : dataBase.users) {
            dataBase.visitedBy(d, user);
            for (Integer i : bst.keys()) {
                Nodes node = bst.get(i);
                for (PoI poI : node.getPoI()) {
                    if (!dataBase.visitedBy(d, user).contains(poI)) {
                        notVisited.add(poI.getName());

                    }
                }
            }
        }

        for (String s : notVisited) {
            out.println("-PoI: " + s);
        }

        out.println("At this date: " + d + " these users visited a point of interest:");
        for (Integer nodeKey : bst.keys()) {
            for (PoI poi : dataBase.searchNode(nodeKey).getPoI()) {
                out.println("-PoI:" + poi.getName());
                users = dataBase.whoVisited(d, poi);
                for (User user : users) {
                    out.println("-PoI:" + poi.getName());
                    out.println("---User id: " + user.getId());
                }
            }
        }
        out.println("At this date: " + d + " these points of interest were not visited:");
        for (Integer nodeKey : bst.keys()) {
            for (PoI poi : dataBase.searchNode(nodeKey).getPoI()) {
                out.println("-PoI id: " + poi.getId());
            }
        }
    }

    public static void loadTop5sToFile(String path) {
        Out out = new Out(path);
        ArrayList<User> top5users;
        ArrayList<PoI> top5pois;

        out.println("At this date: " + d + " these are the top 5 users that visited most points of interest:");
        top5users = dataBase.top5Users(d);
        for (User user : top5users) {
            out.println("-User id: " + user.getId());
        }

        out.println("At this date: " + d + " these are the top 5 points of interest most visited:");
        top5pois = dataBase.top5PoIs(d);
        for (PoI poI : top5pois) {
            out.println("-PoI id: " + poI.getId());
        }
    }

    public static void loadOverpopulatedNodesToBin(String path, int from, int to) {
        DataOutputStream dos = null;
        Iterator itr = dataBase.set.iterator();

        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
            String msg1 = "At this date: ";
            msg1 = msg1.concat(d.toString());
            msg1 = msg1.concat(" there were these overpopulated nodes:\n");
            dos.writeChars(msg1);
            String msg2 = "-Node id: ";
            String msg3 = "\n";

            while (itr.hasNext()) {
                Nodes node = (Nodes) itr.next();
                dos.writeChars(msg2);
                dos.writeInt(node.getId());
                dos.writeChars(msg3);
            }

            dataBase.shortestPathNotOverpopulated(from, to);
            String msg4 = "Shortest non overpopulated path from vertex ";
            msg4 = msg4.concat(String.valueOf(from));
            msg4 = msg4.concat(" to vertex ");
            msg4 = msg4.concat(String.valueOf(to));
            msg4 = msg4.concat(" is ");
            msg4 = msg4.concat(String.valueOf(dataBase.sp.distTo(to)));
            String msg5 = "There's no such path or there's no non overpopulated route.";
            if (dataBase.sp.hasPathTo(to)) {
                dos.writeChars(String.valueOf(dataBase.sp.pathTo(to)));
                dos.writeChars(msg4);
            } else {
                dos.writeChars(msg5);
            }

            dos.writeChars(msg3);
            dataBase.shortestPath(from, to);
            String msg6 = "Shortest path from vertex ";
            msg6 = msg6.concat(String.valueOf(from));
            msg6 = msg6.concat(" to vertex ");
            msg6 = msg6.concat(String.valueOf(to));
            msg6 = msg6.concat(" is ");
            msg6 = msg6.concat(String.valueOf(dataBase.sp.distTo(to)));
            String msg7 = "There's no such path.";
            if (dataBase.sp.hasPathTo(to)) {
                dos.writeChars(String.valueOf(dataBase.sp.pathTo(to)));
                dos.writeChars(msg6);
            } else {
                dos.writeChars(msg7);
            }
        } catch (Exception var20) {
            StdOut.print(var20);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (Exception var19) {
                StdOut.print(var19);
            }

        }

    }

    public static void loadGraphToBin(String path) {
        DataOutputStream dos = null;

        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
            String msg1 = "Check graph connectivity data:\n";
            dos.writeChars(msg1);
            String msg2 = "The graph is connected.";
            String msg3 = "The graph isn't connected.";
            if (dataBase.checkConnectivity() == 0) {
                dos.writeChars(msg2);
            } else {
                dos.writeChars(msg3);
            }

            String msg4 = "\n";
            dos.writeChars(msg4);
            String msg5 = "Check subgraph connectivity data:\n";
            dos.writeChars(msg5);
            String msg6 = "The subgraph is connected.";
            String msg7 = "The subgraph isn't connected.";
            if (dataBase.checkSubGraphConnectivity() == 0) {
                dos.writeChars(msg6);
            } else {
                dos.writeChars(msg7);
            }
        } catch (Exception var17) {
            StdOut.print(var17);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (Exception var16) {
                StdOut.print(var16);
            }

        }

    }

    public static void loadNodesVisitToBin(String path) {
        DataOutputStream dos = null;
        new ArrayList();
        new ArrayList();

        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
            String msg1 = "At this date: ";
            msg1 = msg1.concat(d.toString());
            msg1 = msg1.concat(" these points of interest were visited by a user:\n");
            dos.writeChars(msg1);
            String msg6 = "\n";
            Iterator var6 = dataBase.users.iterator();

            String msg7;
            Iterator var9;
            while (var6.hasNext()) {
                User user = (User) var6.next();
                ArrayList<PoI> visitedPoI = dataBase.visitedBy(d, user);
                msg7 = "-";
                msg7 = msg7.concat(user.getName());
                dos.writeChars(msg7);
                dos.writeChars(msg6);
                var9 = visitedPoI.iterator();

                while (var9.hasNext()) {
                    PoI poI = (PoI) var9.next();
                    String msg3 = "---PoI name: ";
                    msg3 = msg3.concat(poI.getName());
                    dos.writeChars(msg3);
                    dos.writeChars(msg6);
                }
            }

            dos.writeChars(msg6);
            Set<String> notVisited = new HashSet();
            String msg4 = "At this date: ";
            msg4 = msg4.concat(d.toString());
            msg4 = msg4.concat(" these points of interest were not visited by any user:\n");
            dos.writeChars(msg4);
            Iterator var29 = dataBase.users.iterator();

            Iterator var32;
            Integer nodeKey;
            while (var29.hasNext()) {
                User user = (User) var29.next();
                dataBase.visitedBy(d, user);
                var32 = bst.keys().iterator();

                while (var32.hasNext()) {
                    nodeKey = (Integer) var32.next();
                    Nodes node = (Nodes) bst.get(nodeKey);
                    Iterator var13 = node.getPoI().iterator();

                    while (var13.hasNext()) {
                        PoI poI = (PoI) var13.next();
                        if (!dataBase.visitedBy(d, user).contains(poI)) {
                            notVisited.add(poI.getName());
                        }
                    }
                }
            }

            var29 = notVisited.iterator();

            String msg10;
            while (var29.hasNext()) {
                msg10 = (String) var29.next();
                String msg5 = "-PoI ";
                msg5 = msg5.concat(msg10);
                dos.writeChars(msg5);
                dos.writeChars(msg6);
            }

            dos.writeChars(msg6);
            msg7 = "At this date: ";
            msg7 = msg7.concat(d.toString());
            msg7 = msg7.concat(" these users visited a point of interest:\n");
            dos.writeChars(msg7);
            var9 = bst.keys().iterator();

            while (var9.hasNext()) {
                nodeKey = (Integer) var9.next();
                Iterator var36 = dataBase.searchNode(nodeKey).getPoI().iterator();

                while (var36.hasNext()) {
                    PoI poi = (PoI) var36.next();
                    String msg8 = "-PoI: ";
                    msg8 = msg8.concat(poi.getName());
                    dos.writeChars(msg8);
                    dos.writeChars(msg6);
                    ArrayList<User> users = dataBase.whoVisited(d, poi);
                    Iterator var41 = users.iterator();

                    while (var41.hasNext()) {
                        User user = (User) var41.next();
                        String msg9 = "---User id: ";
                        msg9 = msg9.concat(String.valueOf(user.getId()));
                        dos.writeChars(msg9);
                        dos.writeChars(msg6);
                    }
                }
            }

            dos.writeChars(msg6);
            msg10 = "At this date: ";
            msg10 = msg10.concat(d.toString());
            msg10 = msg10.concat(" these points of interest were not visited:\n");
            dos.writeChars(msg10);
            var32 = bst.keys().iterator();

            while (var32.hasNext()) {
                nodeKey = (Integer) var32.next();
                Iterator var38 = dataBase.searchNode(nodeKey).getPoI().iterator();

                while (var38.hasNext()) {
                    PoI poi = (PoI) var38.next();
                    String msg11 = "-PoI id: ";
                    msg11 = msg11.concat(String.valueOf(poi.getId()));
                    dos.writeChars(msg11);
                    dos.writeChars(msg6);
                }
            }
        } catch (Exception var25) {
            StdOut.print(var25);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (Exception var24) {
                StdOut.print(var24);
            }

        }

    }

    public static void loadTop5sToBin(String path) {
        DataOutputStream dos = null;

        try {
            dos = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(path)));
            String msg1 = "At this date: ";
            msg1 = msg1.concat(d.toString());
            msg1 = msg1.concat(" these are the top 5 users that visited most points of interest:");
            dos.writeChars(msg1);
            String msg2 = "\n";
            dos.writeChars(msg2);
            ArrayList<User> top5users = dataBase.top5Users(d);
            Iterator var6 = top5users.iterator();

            while (var6.hasNext()) {
                User user = (User) var6.next();
                String msg3 = "-User id: ";
                msg3 = msg3.concat(String.valueOf(user.getId()));
                dos.writeChars(msg3);
                dos.writeChars(msg2);
            }

            dos.writeChars(msg2);
            String msg4 = "At this date: ";
            msg4 = msg4.concat(d.toString());
            msg4 = msg4.concat(" these are the top 5 points of interest most visited:");
            dos.writeChars(msg4);
            dos.writeChars(msg2);
            ArrayList<PoI> top5pois = dataBase.top5PoIs(d);
            Iterator var21 = top5pois.iterator();

            while (var21.hasNext()) {
                PoI poI = (PoI) var21.next();
                String msg5 = "-PoI id: ";
                msg5 = msg5.concat(String.valueOf(poI.getId()));
                dos.writeChars(msg5);
                dos.writeChars(msg2);
            }
        } catch (Exception var18) {
            StdOut.print(var18);
        } finally {
            try {
                if (dos != null) {
                    dos.close();
                }
            } catch (Exception var17) {
                StdOut.print(var17);
            }

        }

    }

    public static void loadFiles() {
        String fileSource1 = "data\\dataset1_nodes.txt";
        String fileSource2 = "data\\dataset1_ways_nodepairs.txt";
        String fileSource3 = "data\\dataset1_pois.txt";
        String fileSource4 = "data\\dataset1_users.txt";
        String fileSource5 = "data\\dataset1_nodes_bin.bin";
        String fileSource6 = "data\\dataset1_ways_nodepairs_bin.bin";
        String fileSource7 = "data\\dataset1_pois_bin.bin";
        String fileSource8 = "data\\datasete1_users_bin.bin";
        loadFromFileNodes(fileSource1);
        loadFromFileWays(fileSource2);
        loadFromFilePoI(fileSource3);
        loadFromFileUser(fileSource4);
        fillHash();
    }


    private static void loadFromFileNodes(String path) {
        int size = 0;
        In in = new In(path);
        in.readLine();
        int id;
        int vertexID;
        String value;
        String tag;
        float coordenateX;
        float coordenateY;
        while (!in.isEmpty()) {
            String[] text = in.readLine().split(",");
            id = Integer.parseInt(text[0]);
            coordenateX = Float.parseFloat(text[1]);
            coordenateY = Float.parseFloat(text[2]);
            vertexID = Integer.parseInt(text[3]);
            int tagNumb = text.length - 4;
            int i = 0, u = 4;
            Hashtable<String, String> osm = new Hashtable<>();
            while (tagNumb != 0) {
                tag = text[u];
                value = text[u + 1];
                tagNumb -= 2;
                i++;
                u += 2;
                osm.put(tag, value);
            }
            Coordinate coordinate = new Coordinate(coordenateX, coordenateY);
            ArrayList<Ways> waysArrayList = new ArrayList<>();
            ArrayList<PoI> PoIArrayList = new ArrayList<>();
            Nodes node = new Nodes(osm, id, vertexID, coordinate, PoIArrayList, waysArrayList);
            bst.put(id, node);
            dataBase.setBstSize(size++);
        }
    }

    /**
     * Loads content from file path to Ways database
     *
     * @param path - String
     */
    private static void loadFromFileWays(String path) {
        int size = 0;
        In in = new In(path);
        in.readLine();
        while (!in.isEmpty()) {
            String address = null, address2 = null, address3 = null;
            String[] text = in.readLine().split(",");
            Integer id = Integer.parseInt(text[0]);
            int nodeID1 = Integer.parseInt(text[1]);
            int nodeID2 = Integer.parseInt(text[2]);
            float weight = Float.parseFloat(text[3]);
            Hashtable<String, String> osmWay = new Hashtable<>();
            String value = "";
            String tag = "";
            int tagNumb = text.length - 4;
            int i = 0, u = 4;
            while (tagNumb != 0) {
                if (text[u].equals("name")) {
                    String name = text[u + 1];
                    u += 2;
                    tagNumb -= 2;
                }
                switch (text[u]) {
                    case "addr:city" -> {
                        address = text[u + 1];
                        u += 2;
                        tagNumb -= 2;
                        continue;
                    }
                    case "addr:street" -> {
                        address2 = text[u + 1];
                        u += 2;
                        tagNumb -= 2;
                        continue;
                    }
                    case "addr:postcode" -> {
                        address3 = text[u + 1];
                        u += 2;
                        tagNumb -= 2;
                        continue;
                    }
                }

                tag = text[u];
                value = text[u + 1];
                tagNumb -= 2;
                i++;
                u += 2;
                osmWay.put(tag, value);
            }

            Nodes node = bst.get(nodeID1);
            Nodes node2 = bst.get(nodeID2);
            Ways way = new Ways(node.getVertexID(), node2.getVertexID(), weight, id, osmWay, address2, address, address3);
            edges.add(way);
            node2.setWays(way);
            node.setWays(way);
            dataBase.setEdgesSize(size++);
        }
    }

    /**
     * Loads content from file path to PoI database
     *
     * @param path - String
     */
    private static void loadFromFilePoI(String path) {
        In in = new In(path);
        in.readLine();
        int poiID;
        int nodeID;
        String name, Vehicle;
        while (!in.isEmpty()) {
            String[] text = in.readLine().split(",");
            poiID = Integer.parseInt(text[0]);
            nodeID = Integer.parseInt(text[1]);
            name = text[2];
            Vehicle = text[3];

            PoI poi = new PoI(poiID, nodeID, name, Vehicle);
            Nodes node = bst.get(nodeID);
            node.getPoI().add(poi);
            bst.put(nodeID, node);
        }
    }

    /**
     * Loads content from file path to User database
     *
     * @param path - String
     */
    private static void loadFromFileUser(String path) {
        In in = new In(path);
        in.readLine();
        int nodeID;
        int tagNumb, u, poiID, userID;
        String name, vehicle;
        String[] bd, nodesVisited, dateNodeVisited;

        while (!in.isEmpty()) {
            ArrayList<PoI> poI = new ArrayList<>();
            ArrayList<NodeVisited> visitedNodes = new ArrayList<>();
            String[] text = in.readLine().split(",");
            userID = Integer.parseInt(text[0]);
            name = text[1];
            bd = text[2].split("-");
            vehicle = text[3];
            tagNumb = text.length - 4;
            u = 4;
            while (tagNumb >= 0) {
                nodesVisited = text[u].split(":");
                nodeID = Integer.parseInt(nodesVisited[1]);
                poiID = Integer.parseInt(nodesVisited[2]);
                dateNodeVisited = nodesVisited[3].split("-");
                Date nodeVisitedDate = new Date(Integer.parseInt(dateNodeVisited[0]), Integer.parseInt(dateNodeVisited[1]), Integer.parseInt(dateNodeVisited[2]));
                Nodes node = bst.get(nodeID);
                for (PoI poi1 : node.getPoI()) {
                    if (node.getPoI().contains(node.getPoI().get(node.getPoI().indexOf(poi1)))) {
                        poI.add(poi1);
                    }
                }
                NodeVisited nodeVisited = new NodeVisited(nodeID, nodeVisitedDate, poI);
                visitedNodes.add(nodeVisited);
                u += 2;
                tagNumb -= 2;
            }
            Date bday = new Date(Integer.parseInt(bd[0]), Integer.parseInt(bd[1]), Integer.parseInt(bd[2]));
            User user = new User(userID, name, bday, vehicle, visitedNodes);
            dataBase.addUser(user);
        }
    }

    /**
     * Fills HashTable from database with Nodes and Ways tags
     */
    private static void fillHash() {
        for (Integer i : bst.keys()) {
            Nodes node = bst.get(i);
            Set<String> a = node.osmNode.keySet();
            String text = null;
            for (String key : a) text = key;
            int x = 0;
            ArrayList<Nodes> vertice = new ArrayList<>();
            ArrayList<Ways> edges = new ArrayList<>();
            Grafo grafo = new Grafo(edges, vertice);
            grafo.setVertices(node);
            if (text != null && DataBase.ht.containsKey(text)) {
                grafo = DataBase.ht.get(text);
                grafo.setVertices(node);
                DataBase.ht.put(text, grafo);
            }
            if (text != null) {
                DataBase.ht.put(text, grafo);
            }
        }

        for (Ways edge : edges) {
            Set<String> a = edge.osmWay.keySet();
            String text = "";
            for (String key : a) text = key;
            int x = 0;

            ArrayList<Nodes> vertice = new ArrayList<>();
            ArrayList<Ways> edges = new ArrayList<>();
            Grafo newGrafo = new Grafo(edges, vertice);
            newGrafo.setEdges(edge);
            if (DataBase.ht.containsKey(text)) {
                newGrafo = DataBase.ht.get(text);
                newGrafo.setEdges(edge);
                DataBase.ht.put(text, newGrafo);
                x++;
                continue;
            }
            DataBase.ht.put(text, newGrafo);
            x++;

        }
    }

}