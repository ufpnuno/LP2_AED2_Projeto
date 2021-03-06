package com.projeto;


import edu.princeton.cs.algs4.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.*;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import static java.lang.System.exit;
import static java.lang.System.out;


/**
 * The type Data base.
 */
public class DataBase implements Initializable {


    /**
     * The Textfield name.
     */
    public TextField textfieldName;
    /**
     * The Birthday.
     */
    public DatePicker Birthday;
    /**
     * The Textfield vehicle.
     */
    public TextField textfieldVehicle;
    /**
     * The Add btn.
     */
    public Button addBtn;
    /**
     * The Edit btn.
     */
    public Button editBtn;
    /**
     * The Remove btn.
     */
    public Button removeBtn;

    /**
     * The Table view.
     */
//Basic Information tab
    public TableView<User> tableView;
    /**
     * The Col id.
     */
    public TableColumn<User, Integer> colID;
    /**
     * The Col name.
     */
    public TableColumn<User, String> colName;
    /**
     * The Col birthday.
     */
    public TableColumn<User, Date> colBirthday;
    /**
     * The Col vehicle.
     */
    public TableColumn<User, String> colVehicle;
    /**
     * The Search field name.
     */
    public TextField searchFieldName;
    /**
     * The Search btn.
     */
    public Button searchBtn;

    /**
     * The Table view nodes visited.
     */
//DateVisited tab
    public TableView<NodeVisited> tableViewNodesVisited;
    /**
     * The User id.
     */
    public TableColumn<NodeVisited, Integer> userID;
    /**
     * The Node id.
     */
    public TableColumn<Nodes, Integer> nodeID;
    /**
     * The Date visited.
     */
    public TableColumn<NodeVisited, Date> dateVisited;

    /**
     * The Poi node id.
     */
//PoI tab
    public TableColumn<Nodes, Integer> poiNodeID;
    /**
     * The Poi id.
     */
    public TableColumn<PoI, Integer> poiID;
    /**
     * The Poi name.
     */
    public TableColumn<PoI, String> poiName;
    /**
     * The Poi vehicle.
     */
    public TableColumn<PoI, String> poiVehicle;
    /**
     * The Table view po i.
     */
    public TableView<PoI> tableViewPoI;
    /**
     * The Node visited field.
     */
    public TextField NodeVisitedField;
    /**
     * The Date visited field.
     */
    public DatePicker DateVisitedField;

    /**
     * The Table view nodes.
     */
//Nodes tab
    public TableView<Nodes> tableViewNodes;
    /**
     * The Id.
     */
    public TableColumn<Nodes, Integer> ID;
    /**
     * The Vertex id.
     */
    public TableColumn<Nodes, Integer> vertexID;
    /**
     * The Coordinates.
     */
    public TableColumn<Nodes, Coordinate> coordinates;
    /**
     * The Poi.
     */
    public TableColumn<Nodes, PoI> poi;
    /**
     * The Ways.
     */
    public TableColumn<Nodes, Ways> ways;
    /**
     * The Nodeidtextfield.
     */
    public TextField nodeidtextfield;
    /**
     * The Vertex id text field.
     */
    public TextField vertexIdTextField;
    /**
     * The Coordinate x text field.
     */
    public TextField coordinateXTextField;
    /**
     * The Add node btn.
     */
    public Button addNodeBtn;
    /**
     * The Edit node btn.
     */
    public Button editNodeBtn;
    /**
     * The Remove node btn.
     */
    public Button removeNodeBtn;
    /**
     * The Coordinate y text field.
     */
    public TextField coordinateYTextField;
    /**
     * The Poi text field.
     */
    public TextField poiTextField;
    /**
     * The Ways text field.
     */
    public TextField waysTextField;
    /**
     * The Search field node.
     */
    public TextField searchFieldNode;
    /**
     * The Search node btn.
     */
    public Button searchNodeBtn;
    /**
     * The Value text field.
     */
    public TextField valueTextField;
    /**
     * The Tag text field.
     */
    public TextField tagTextField;
    /**
     * The Table view tag.
     */
    public TableView<Nodes> tableViewTag;
    /**
     * The Tag node id.
     */
    public TableColumn<Nodes, Integer> tagNodeID;
    /**
     * The Tag col.
     */
    public TableColumn<Nodes, String> tagCol;
    /**
     * The Value col.
     */
    public TableColumn<Nodes, String> valueCol;
    /**
     * The Table view po i 2.
     */
// Node - PoI tab
    public TableView<PoI> tableViewPoI2;
    /**
     * The Col poi.
     */
    public TableColumn<PoI, Integer> colPOI;
    /**
     * The Col node id.
     */
    public TableColumn<PoI, Integer> colNodeID;
    /**
     * The Col poi name.
     */
    public TableColumn<PoI, String> colPOIName;
    /**
     * The Col vehicle poi.
     */
    public TableColumn<PoI, String> colVehiclePOI;
    /**
     * The Graph group.
     */
    public Group graphGroup;
    /**
     * The Graph btn.
     */
    public Button graphBtn;
    /**
     * The Shortest path btn.
     */
    public Button shortestPathBtn;
    /**
     * The From id.
     */
    public TextField fromID;
    /**
     * The To id.
     */
    public TextField toID;
    /**
     * The Short date.
     */
    public DatePicker shortDate;

    /**
     * The Table view nodes 1.
     */
// Ways
    public TableView<Ways> tableViewNodes1;
    /**
     * The Way id.
     */
    public TableColumn<Ways, Integer> wayID;
    /**
     * The Way node v.
     */
    public TableColumn<Ways, Integer> wayNodeV;
    /**
     * The Way node w.
     */
    public TableColumn<Ways, Integer> wayNodeW;
    /**
     * The Way weight.
     */
    public TableColumn<Ways, Double> wayWeight;
    /**
     * The Way id text field.
     */
    public TextField wayIdTextField;
    /**
     * The Way node v text field.
     */
    public TextField wayNodeVTextField;
    /**
     * The Way node w text field.
     */
    public TextField wayNodeWTextField;
    /**
     * The Add way btn.
     */
    public Button addWayBtn;
    /**
     * The Edit way btn.
     */
    public Button EditWayBtn;
    /**
     * The Remove way btn.
     */
    public Button removeWayBtn;
    /**
     * The Way weight text field.
     */
    public TextField wayWeightTextField;
    /**
     * The Tag way text field.
     */
    public TextField tagWayTextField;
    /**
     * The Value way text field.
     */
    public TextField valueWayTextField;
    /**
     * The Search field way.
     */
    public TextField searchFieldWay;
    /**
     * The Search way btn.
     */
    public Button searchWayBtn;
    /**
     * The Address text field.
     */
    public TextField addressTextField;
    /**
     * The Post code text field.
     */
    public TextField PostCodeTextField;
    /**
     * The Way address.
     */
    public TableColumn<Ways, String> wayAddress;
    /**
     * The Way post code.
     */
    public TableColumn<Ways, String> wayPostCode;
    /**
     * The Table view tag 1.
     */
    public TableView<Ways> tableViewTag1;
    /**
     * The Way tag id.
     */
    public TableColumn<Ways, Integer> wayTagId;
    /**
     * The Way tag col.
     */
    public TableColumn<Ways, String> wayTagCol;
    /**
     * The Way name text field.
     */
    public TextField wayNameTextField;
    /**
     * The Way name column.
     */
    public TableColumn<Ways, String> wayNameColumn;

    /**
     * The Poi id text field.
     */
// PoI
    public TextField poiIDTextField;
    /**
     * The Node idpoi text field.
     */
    public TextField nodeIDPOITextField;
    /**
     * The Po i name text field.
     */
    public TextField PoINameTextField;
    /**
     * The Add po i btn.
     */
    public Button addPoIBtn;
    /**
     * The Edit po i btn.
     */
    public Button editPoIBtn;
    /**
     * The Remove po i btn.
     */
    public Button removePoIBtn;
    /**
     * The Poi vehicle text field.
     */
    public TextField poiVehicleTextField;


    /**
     * The Observable poi list 2.
     */
    ObservableList<PoI> observablePoiList2 = FXCollections.observableArrayList();
    /**
     * The Observable user list.
     */
    ObservableList<User> observableUserList = FXCollections.observableArrayList();
    /**
     * The Observable node visited list.
     */
    ObservableList<NodeVisited> observableNodeVisitedList = FXCollections.observableArrayList();
    /**
     * The Observable poi list.
     */
    ObservableList<PoI> observablePoiList = FXCollections.observableArrayList();
    /**
     * The Observable node list.
     */
    ObservableList<Nodes> observableNodeList = FXCollections.observableArrayList();
    /**
     * The Observable ways list.
     */
    ObservableList<Ways> observableWaysList = FXCollections.observableArrayList();

    private static final String fileSource1 = "data\\dataset1_nodes.txt";
    private static final String fileSource2 = "data\\dataset1_ways_nodepairs.txt";
    private static final String fileSource3 = "data\\dataset1_pois.txt";
    private static final String fileSource4 = "data\\dataset1_users.txt";
    private static final String fileSource5 = "data\\dataset1_nodes_bin.bin";
    private static final String fileSource6 = "data\\dataset1_ways_nodepairs_bin.bin";
    private static final String fileSource7 = "data\\dataset1_pois_bin.bin";
    private static final String fileSource8 = "data\\datasete1_users_bin.bin";

    /**
     * The Users size.
     */
    public Integer usersSize;

    /**
     * Sets users size.
     *
     * @param usersSize the users size
     */
    public void setUsersSize(Integer usersSize) {
        this.usersSize = usersSize;
    }

    /**
     * Sets users size.
     *
     * @return the users size
     */
    public Integer setUsersSize() {
        return usersSize;
    }

    /**
     * The Bst.
     */
    public static BinarySearchST<Integer, Nodes> bst = new BinarySearchST<>();
    /**
     * The Ht.
     */
    public static Hashtable<String, Grafo> ht = new Hashtable<>();

    /**
     * The Users.
     */
    public ArrayList<User> users = new ArrayList<>();
    /**
     * The Edges.
     */
    public static ArrayList<Ways> edges = new ArrayList<>();
    /**
     * The Set.
     */
    public Set<Nodes> set = new HashSet<>();

    /**
     * The Ewg.
     */
    public EdgeWeightedDigraph ewg;

    /**
     * The Sp.
     */
    public DijkstraSP sp;

    /**
     * The Sub graph.
     */
    public EdgeWeightedDigraph subGraph;
    /**
     * The Bst size.
     */
    public Integer bstSize;


    /**
     * Gets bst size.
     *
     * @return the bst size
     */
    public Integer getBstSize() {
        return bstSize;
    }

    /**
     * Sets bst size.
     *
     * @param bstSize the bst size
     */
    public void setBstSize(Integer bstSize) {
        this.bstSize = bstSize;
    }

    /**
     * The Edges size.
     */
    public Integer edgesSize;

    /**
     * Gets edges size.
     *
     * @return the edges size
     */
    public Integer getEdgesSize() {
        return edgesSize;
    }

    /**
     * Sets edges size.
     *
     * @param edgesSize the edges size
     */
    public void setEdgesSize(Integer edgesSize) {
        this.edgesSize = edgesSize;
    }

    /**
     * Instantiates a new Data base.
     */
    public DataBase() {
    }

    /**
     * Creates graph
     */
    public void createGraph() {
        ewg = new EdgeWeightedDigraph(getBstSize() + 1);
    }

    /**
     * Prints Graph
     */
    public void printGraph() {
        StdOut.println(ewg.toString());
    }

    /**
     * Adds edges to the graph
     */
    public void addEdges() {
        ewg = new EdgeWeightedDigraph(getBstSize() + 1);
        for (Ways ways : edges) {
            DirectedEdge edge = new DirectedEdge(ways.getV(), ways.getW(), ways.getWeight());
            ewg.addEdge(edge);

        }
    }

    /**
     * Set of overpopulated nodes
     *
     * @param timestamp - Date
     */
    public void overPopulatedNode(Date timestamp) {
        int count = 0;
        for (Integer i : bst.keys()) {
            Nodes node = bst.get(i);
            for (User user : users) {
                for (NodeVisited nodeVisited : user.getNodesVisited()) {
                    if ((node.getId().equals(nodeVisited.getNodeID()) && (nodeVisited.getDateVisited().compareTo(timestamp)) > 0)) {
                        count++;
                        if (count == 5) {
                            set.add(node);
                        }
                    }
                }
            }
            count = 0;
        }
    }

    /**
     * Checks if there is connectivity in the graph
     *
     * @return the int
     */
    public int checkConnectivity() {

        out.println("Graph connectivity data:");
        int flag = 0;
        Graph graph = new Graph(bstSize + 1);
        for (Ways ways : edges) {
            graph.addEdge(ways.getV(), ways.getW());
        }

        for (int i = 0; i < getBstSize() + 1; i++) {
            DepthFirstSearch dfs = new DepthFirstSearch(graph, i);
            for (int v = 0; v < graph.V(); v++) {
                if (dfs.marked(v)) StdOut.print(v + " ");
            }
            StdOut.println();
            if (dfs.count() != graph.V()) {
                flag = 1;
            }
        }
        if (flag == 1) {
            out.println("The graph isn't connected");
            return 1;
        } else {
            out.println("The graph is connected");
            return 0;
        }
    }

    /**
     * Checks if there is connectivity in the sub graph
     *
     * @return the int
     */
    public int checkSubGraphConnectivity() {
        out.println("Subgraph connectivity data:");
        Graph graph = new Graph(bstSize + 1);

        int flag = 0;
        for (Ways way : edges) {
            for (Nodes nodes : set) {
                if (nodes.getVertexID() == way.getW() || nodes.getVertexID() == way.getV()) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                graph.addEdge(way.getV(), way.getW());
            }
            flag = 0;
        }

        for (int u = 0; u < getBstSize() + 1; u++) {
            DepthFirstSearch dfs = new DepthFirstSearch(graph, u);
            for (int v = 0; v < graph.V(); v++) {
                if (dfs.marked(v)) StdOut.print(v + " ");
            }
            StdOut.println();
            if (dfs.count() != graph.V()) {
                flag = 1;
            }
        }
        if (flag == 1) {
            out.println("The subgraph isn't connected");
            return 1;
        } else {
            out.println("The subgraph is connected");
            return 0;
        }
    }


    /**
     * Calculates the shortest path that is non overpopulated from one vertex to another
     *
     * @param from - starting vertex
     * @param to   - to vertex
     */
    public void shortestPathNotOverpopulated(int from, int to) {
        subGraph = new EdgeWeightedDigraph(getBstSize() + 1);


        int flag = 0;
        for (Ways way : edges) {
            for (Nodes nodes : set) {
                if (nodes.getVertexID() == way.getW() || nodes.getVertexID() == way.getV()) {
                    flag = 1;
                }
            }
            if (flag == 0) {
                DirectedEdge edge = new DirectedEdge(way.getV(), way.getW(), way.getWeight());
                subGraph.addEdge(edge);
            }
            flag = 0;
        }

        sp = new DijkstraSP(subGraph, from);

    }

    /**
     * Calculates the shortest path from one vertex to another
     *
     * @param from - starting vertex
     * @param to   - to vertex
     */
    public void shortestPath(int from, int to) {
        sp = new DijkstraSP(ewg, from);
    }

    /**
     * Adds the tag ( key ) and the respective Graph Object
     *
     * @param tag           - the tag
     * @param edgeOrVertice - Graph object
     */
    public void addTag(String tag, Grafo edgeOrVertice) {
        ht.put(tag, edgeOrVertice);
    }

    /**
     * Removes the tag ( key ) and the respective Graph Object
     *
     * @param tag - the tag
     */
    public void removeTag(String tag) {
        ht.remove(tag);
    }

    /**
     * Searches if tag exists in the Hashtable
     *
     * @param tag - the tag
     * @return true or false
     */
    public boolean searchTag(String tag) {
        return ht.contains(tag);
    }

    /**
     * Prints the whole Hashtable
     */
    public void printHash() {
        StdOut.println(ht.toString());
    }


    /**
     * Inserts the specified edge into the ways ArrayList
     *
     * @param newEdge - node class
     */
    public void addEdge(Ways newEdge) {
        edges.add(newEdge);
    }

    /**
     * Deletes edge's node
     *
     * @param edgeToDelete - the edge
     */
    public void deleteEdge(Ways edgeToDelete) {
        for (Integer i : bst.keys()) {
            Nodes node = bst.get(i);
            for (Ways way : node.getWays()) {
                if (way == edgeToDelete) {
                    node.getWays().remove(edgeToDelete);
                }
            }
        }
        edges.remove(edgeToDelete);
    }

    /**
     * Searchs for edge. If it exists or not
     *
     * @param edgeToBeSearched - the edge
     * @return the boolean
     */
    public boolean searchEdge(Ways edgeToBeSearched) {
        return edges.contains(edgeToBeSearched);
    }

    /**
     * Prints the whole edge ArrayList
     */
    public void printEdges() {
        for (Ways edge : edges) {
            StdOut.print(edge + "\n");
        }
    }

    /**
     * Inserts the specified key-value into the symbol table
     *
     * @param key  - the key
     * @param node - node class
     */
    public void addNode(int key, Nodes node) {
        bst.put(key, node);
    }

    /**
     * Edits BST through key
     *
     * @param key  - the key
     * @param node - node class
     */
    public void editNode(int key, Nodes node) {
        if (bst.get(key) != null) {
            bst.put(key, node);
        }
    }

    /**
     * Deletes key's node
     *
     * @param key - the key
     */
    public void deleteNode(Integer key) {
        Nodes node;
        for (Integer i : bst.keys()) {
            if (i.equals(key)) {
                node = bst.get(i);
                for (User user : users) {
                    for (NodeVisited nodevisited : user.nodesVisited) {
                        if ((node.getId().equals(nodevisited.getNodeID()))) {
                            user.nodesVisited.remove(nodevisited);
                            break;
                        }
                    }
                }
                bst.delete(key);
                out.println("Node removed successfully.");
            }
        }
    }

    /**
     * Searches for the specified key's value
     *
     * @param key - the key
     * @return the nodes
     */
    public Nodes searchNode(int key) {
        return bst.get(key);
    }

    /**
     * Prints the whole BST
     */
    public void printBST() {
        for (Integer i : bst.keys()) {
            StdOut.println(i + " " + bst.get(i).toString());
        }
    }

    /**
     * Inserts user into Arraylist
     *
     * @param user - user object
     */
    public void addUser(User user) {
        users.add(user);
    }

    /**
     * Finds user name and replaces with the new object
     *
     * @param user - user object
     */
    public void editUser(User user) {
        Iterator<User> u = users.iterator();
        int i = 0;
        while (u.hasNext()) {
            if (u.next().name.equals(user.name)) {
                users.set(i + 1, user);
            }
            i++;
        }
    }

    /**
     * Deletes given user
     *
     * @param userID - user ID
     */
    public void deleteUser(int userID) {
        users.removeIf(user -> user.id == userID);
    }

    /**
     * Searches for user
     *
     * @param userID - user ID
     * @return true or false depending wether there's an user or not
     */
    public boolean searchUser(int userID) {
        return users.contains(userID);
    }

    /**
     * Prints arrayList of users
     */
    public void printUserList() {
        for (User user : users) {
            out.println(user.toString());
        }
    }

    /**
     * Finds points of interest that were visited by a user in a certain period of time
     *
     * @param d    - the date
     * @param user - user class
     * @return the array list
     */
    public ArrayList<PoI> visitedBy(Date d, User user) {
        ArrayList<PoI> visitedPoI = new ArrayList<>();
        for (User user1 : users) {
            if (user1.id.equals(user.id)) {
                for (NodeVisited nodeVisited1 : user.getNodesVisited()) {
                    if (nodeVisited1.getDateVisited().compareTo(d) > 0) {
                        for (Integer i : bst.keys()) {
                            boolean b = Objects.equals(bst.get(i).getId(), nodeVisited1.getNodeID());
                            if (b) {
                                visitedPoI.addAll(nodeVisited1.getPoI());
                            }
                        }
                    }
                }
            }
        }
        return visitedPoI;
    }

    /**
     * Finds points of interest that were not visited by a user in a certain period of time
     *
     * @param d    - the date
     * @param user - user class
     * @return the array list
     */
    public ArrayList<PoI> notVisitedBy(Date d, User user) {
        ArrayList<PoI> notVisitedPoI = new ArrayList<>();
        for (User user1 : users) {
            if (user1.id.equals(user.id)) {
                for (Integer i : bst.keys()) {
                    for (NodeVisited nodeVisited1 : user.getNodesVisited()) {
                        for (PoI poi : bst.get(i).getPoI()) {
                            if (nodeVisited1.getDateVisited().compareTo(d) > 0 && !nodeVisited1.getPoI().contains(poi)) {
                                notVisitedPoI.add(poi);
                            }
                        }
                    }
                }
            }
        }
        return notVisitedPoI;
    }

    /**
     * Finds points of interest that were visited in a certain period of time
     *
     * @param d - the date
     * @param p - point of interest class
     * @return the array list
     */
    public ArrayList<User> whoVisited(Date d, PoI p) {
        ArrayList<User> usersWhoVisited = new ArrayList<>();
        for (User user : users) {
            for (NodeVisited node : user.getNodesVisited()) {
                for (PoI poi : node.getPoI()) {
                    if (poi == p) {
                        for (Integer i : bst.keys()) {
                            if (node.getNodeID().equals(bst.get(i).getId()) && node.getDateVisited().compareTo(d) > 0) {
                                usersWhoVisited.add(user);
                            }
                        }
                    }
                }
            }
        }
        return usersWhoVisited;
    }

    /**
     * Finds points of interest that weren't visited on a certain period of time
     *
     * @param d - the date
     * @return the array list
     */
    public ArrayList<PoI> notVisitedPoI(Date d) {
        ArrayList<PoI> notVisited = new ArrayList<>();
        for (User user : users) {
            for (Integer i : bst.keys()) {
                if (!user.getNodesVisited().contains(bst.get(i).getId()) || (user.getNodesVisited().contains(d.afterDate(d)) && user.getNodesVisited().contains(bst.get(i).getId()))) {
                    notVisited.addAll(bst.get(i).getPoI());
                }
            }
        }
        return notVisited;
    }

    /**
     * Finds top 5 users that visited most points of interest
     *
     * @param d - the date
     * @return the array list
     */
    public ArrayList<User> top5Users(Date d) {
        ArrayList<User> top5usersWhoVisitedMostPoI = new ArrayList<>();
        Map<String, Integer> tempMap = new HashMap<>();
        for (User user : users) {
            int counter = 0;
            for (int i = 0; i < user.getNodesVisited().size(); i++) {
                NodeVisited node = user.getNodesVisited().get(i);
                if (node.getDateVisited().compareTo(d) > 0) {
                    counter += node.getPoI().size();
                }
            }
            tempMap.put(user.getName(), counter);
        }

        Map<String, Integer> sortedMap = sortByValue(tempMap);
        int i = 0;
        for (Entry<String, Integer> map : sortedMap.entrySet()) {
            for (User user : users) {
                if (map.getKey().equals(user.getName())) {
                    top5usersWhoVisitedMostPoI.add(user);
                }
            }
            i++;
            if (i == 5) {
                break;
            }
        }

        StdOut.println(top5usersWhoVisitedMostPoI.toString());
        return top5usersWhoVisitedMostPoI;
    }

    /**
     * Sorts an unsorted map by descending order
     *
     * @param unsortMap - Map wanted to be sorted
     * @return - a sorted map
     */
    private static Map<String, Integer> sortByValue(Map<String, Integer> unsortMap) {
        List<Entry<String, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> o2.getValue().compareTo(o1.getValue()) == 0 ? o2.getKey().compareTo(o1.getKey()) : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Entry::getKey, Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }


    /**
     * Finds top 5 points of interest most visited
     *
     * @param d - the date
     * @return the array list
     */
    public ArrayList<PoI> top5PoIs(Date d) {
        ArrayList<PoI> top5PoIs = new ArrayList<>();
        Map<String, Integer> tempMap = new HashMap<>();
        int flag = 0;
        int value = 0;
        for (User user : users) {
            for (NodeVisited nodeVisited : user.getNodesVisited()) {
                if (nodeVisited.getDateVisited().compareTo(d) > 0) {
                    for (PoI poi : nodeVisited.getPoI()) {
                        for (Entry<String, Integer> map : tempMap.entrySet()) {
                            if (map.getKey().equals(poi.getName())) {
                                flag = 1;
                                value = map.getValue();
                            }
                        }
                        if (flag == 1) {
                            tempMap.put(poi.getName(), value + 1);
                        } else {
                            tempMap.put(poi.getName(), value);
                        }
                    }
                }
            }
        }

        Map<String, Integer> sortedMap = sortByValue(tempMap);
        int i = 0;
        for (Entry<String, Integer> map : sortedMap.entrySet()) {
            for (Integer a : bst.keys()) {
                Nodes node = bst.get(a);
                for (PoI poi : node.getPoI()) {
                    if (map.getKey().equals(poi.getName())) {
                        top5PoIs.add(poi);
                    }
                }
            }
            i++;
            if (i == 5) {
                break;
            }
        }
        return top5PoIs;
    }

    /**
     * Looks for a tag in the Hashtable, if it is found, returns an ArrayList of Graph Object
     *
     * @param tag - the tag
     * @return tagFound array list
     */
    public ArrayList<Grafo> tagFound(String tag) {
        ArrayList<Grafo> tagFound = new ArrayList<>();
        if (searchTag(tag)) {
            tagFound.add(ht.get(tag));
        }
        return tagFound;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colBirthday.setCellValueFactory(new PropertyValueFactory<>("Birthday"));
        colVehicle.setCellValueFactory(new PropertyValueFactory<>("Vehicle"));
        userID.setCellValueFactory(new PropertyValueFactory<>("UserID"));
        nodeID.setCellValueFactory(new PropertyValueFactory<>("nodeID"));
        dateVisited.setCellValueFactory(new PropertyValueFactory<>("dateVisited"));
        poiID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        poiName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        poiNodeID.setCellValueFactory(new PropertyValueFactory<>("nodeID"));
        poiVehicle.setCellValueFactory(new PropertyValueFactory<>("Type"));
        ID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        vertexID.setCellValueFactory(new PropertyValueFactory<>("VertexID"));
        coordinates.setCellValueFactory(new PropertyValueFactory<>("Point"));
        ways.setCellValueFactory(new PropertyValueFactory<>("Ways"));
        poi.setCellValueFactory(new PropertyValueFactory<>("PoI"));
        tagNodeID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        tagCol.setCellValueFactory(new PropertyValueFactory<>("OsmNode"));
        colPOI.setCellValueFactory(new PropertyValueFactory<>("Id"));
        colNodeID.setCellValueFactory(new PropertyValueFactory<>("NodeID"));
        colPOIName.setCellValueFactory(new PropertyValueFactory<>("Name"));
        colVehiclePOI.setCellValueFactory(new PropertyValueFactory<>("Type"));
        wayID.setCellValueFactory(new PropertyValueFactory<>("Id"));
        wayNodeV.setCellValueFactory(new PropertyValueFactory<>("V"));
        wayNodeW.setCellValueFactory(new PropertyValueFactory<>("W"));
        wayWeight.setCellValueFactory(new PropertyValueFactory<>("Weight"));
        wayPostCode.setCellValueFactory(new PropertyValueFactory<>("Postcode"));
        wayTagId.setCellValueFactory(new PropertyValueFactory<>("Id"));
        wayTagCol.setCellValueFactory(new PropertyValueFactory<>("OsmWay"));
        wayNameColumn.setCellValueFactory(new PropertyValueFactory<>("Name"));
    }

    /**
     * Writes from file nodes to data structures
     *
     * @param path
     */
    private void loadFromFileNodes(String path) {
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
            setBstSize(size++);
        }
    }

    /**
     * Loads content from file path to Ways database
     *
     * @param path - String
     */
    private void loadFromFileWays(String path) {
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
            setEdgesSize(size++);
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
    private void loadFromFileUser(String path) {
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
            addUser(user);
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
            if (text != null && ht.containsKey(text)) {
                grafo = ht.get(text);
                grafo.setVertices(node);
                ht.put(text, grafo);
            }
            if (text != null) {
                ht.put(text, grafo);
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
            if (ht.containsKey(text)) {
                newGrafo = ht.get(text);
                newGrafo.setEdges(edge);
                ht.put(text, newGrafo);
                x++;
                continue;
            }
            ht.put(text, newGrafo);
            x++;

        }
    }


    private void clearTableItems() {
        observableUserList.removeAll();

    }

    /**
     * Action to be done after a text file is read
     *
     * @param actionEvent the action event
     */
    public void handleReadTextFileAction(ActionEvent actionEvent) {
        clearTableItems();

        try {
            loadFromFileNodes(fileSource1);
            loadFromFileWays(fileSource2);
            loadFromFilePoI(fileSource3);
            loadFromFileUser(fileSource4);
            fillHash();
        } catch (Exception e) {
            e.printStackTrace();
        }

        afterReadFileAction();
    }

    /**
     * Action to be done after a file is read
     */
    private void afterReadFileAction() {

        observableUserList.removeAll();
        observableUserList.addAll(users);
        tableView.setItems(observableUserList);
        for (User user : users) {
            for (NodeVisited nodeVisited : user.getNodesVisited()) {
                observableNodeVisitedList.add(nodeVisited);
                for (PoI poi : nodeVisited.getPoI()) {
                    if (!observablePoiList.contains(poi)) {
                        observablePoiList.add(poi);
                    }
                }
            }
        }

        for (Integer i : bst.keys()) {
            Nodes node = bst.get(i);
            observableNodeList.add(node);
            for (PoI poi : node.getPoI()) {
                if (!observablePoiList2.contains(poi)) {
                    observablePoiList2.add(poi);
                }
            }
        }
        observableWaysList.addAll(edges);

        tableViewNodes.setItems(observableNodeList);
        tableViewTag.setItems(observableNodeList);
        tableViewNodesVisited.setItems(observableNodeVisitedList);
        tableViewPoI.setItems(observablePoiList);
        tableViewPoI2.setItems(observablePoiList2);
        tableViewNodes1.setItems(observableWaysList);
        tableViewTag1.setItems(observableWaysList);

    }


    /**
     * Adds a user to the ST and GUI
     *
     * @param actionEvent the action event
     */
    public void addUserBtn(ActionEvent actionEvent) {
        try {
            String name = textfieldName.getText();
            int day = Birthday.getValue().getDayOfMonth();
            int month = Birthday.getValue().getMonthValue();
            int year = Birthday.getValue().getYear();
            int id = users.size() + 1;
            String Vehicle = textfieldVehicle.getText();
            Date d = new Date(day, month, year);
            ArrayList<NodeVisited> nodeVisitedArrayList = new ArrayList<>();
            String visitedField = NodeVisitedField.getText();
            day = DateVisitedField.getValue().getDayOfMonth();
            month = DateVisitedField.getValue().getMonthValue();
            year = DateVisitedField.getValue().getYear();
            Date d2 = new Date(day, month, year);
            String[] text = visitedField.split(",");
            int length = text.length;
            ArrayList<PoI> poi = new ArrayList<>();
            while (length != 0) {
                String s = text[length - 1];
                int nodeid = Integer.parseInt(s);
                for (Integer x : bst.keys()) {
                    Nodes node = bst.get(x);

                    if (node.getId() == nodeid) {
                        poi.addAll(node.getPoI());
                    }
                }
                NodeVisited nodeVisited = new NodeVisited(nodeid, d2, poi);
                nodeVisitedArrayList.add(nodeVisited);
                length--;
            }
            User user = new User(id, name, d, Vehicle, nodeVisitedArrayList);

            users.add(user);
            tableView.getItems().add(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Edits user on the ST and GUI
     *
     * @param actionEvent the action event
     */
    public void editUserBtn(ActionEvent actionEvent) {
        try {
            String name = textfieldName.getText();
            Iterator<User> u = users.iterator();
            String Vehicle = textfieldVehicle.getText();
            int i = 0;
            while (u.hasNext()) {
                if (u.next().getName().equals(name)) {
                    i = u.next().getId();
                }
            }
            User editedUser = users.get(i - 2);
            int day = Birthday.getValue().getDayOfMonth();
            int month = Birthday.getValue().getMonthValue();
            int year = Birthday.getValue().getYear();
            Date d = new Date(day, month, year);
            editedUser.setBirthday(d);
            ArrayList<NodeVisited> nodeVisitedArrayList = new ArrayList<>();
            String visitedField = NodeVisitedField.getText();
            day = DateVisitedField.getValue().getDayOfMonth();
            month = DateVisitedField.getValue().getMonthValue();
            year = DateVisitedField.getValue().getYear();
            Date d2 = new Date(day, month, year);
            String[] text = visitedField.split(",");
            int length = text.length;
            ArrayList<PoI> poi = new ArrayList<>();
            while (length != 0) {
                String s = text[length - 1];
                int nodeid = Integer.parseInt(s);
                for (Integer x : bst.keys()) {
                    Nodes node = bst.get(x);

                    if (node.getId() == nodeid) {
                        poi.addAll(node.getPoI());
                    }
                }
                NodeVisited nodeVisited = new NodeVisited(nodeid, d2, poi);
                nodeVisitedArrayList.add(nodeVisited);
                length--;
            }
            editedUser.setNodesVisited(nodeVisitedArrayList);
            editedUser.setVehicle(Vehicle);

            tableView.getItems().clear();
            observableUserList.removeAll();
            observableUserList.addAll(users);
        } catch (Exception e) {
            System.out.println("There's no such user to be edited");
        }
    }

    /**
     * Removes user from the ST and GUI
     *
     * @param actionEvent the action event
     */
    public void removeUserBtn(ActionEvent actionEvent) {
        Integer id = tableView.getSelectionModel().getSelectedItem().getId();

        deleteUser(id);
        tableView.getItems().clear();
        afterReadFileAction();
    }

    /**
     * Saves to binary file
     *
     * @param actionEvent the action event
     */
    public void handleSaveBinFileAction(ActionEvent actionEvent) {
        ObjectOutputStream oos = null;
        ObjectOutputStream oos1 = null;
        ObjectOutputStream oos2 = null;
        ObjectOutputStream oos3 = null;

        try {
            oos = new ObjectOutputStream((new FileOutputStream(fileSource5)));
            oos1 = new ObjectOutputStream((new FileOutputStream(fileSource6)));
            oos2 = new ObjectOutputStream(new FileOutputStream(fileSource7));
            oos3 = new ObjectOutputStream(new FileOutputStream(fileSource8));

            for (Integer i : bst.keys()) {
                Nodes node = bst.get(i);
                oos.writeObject(node);
            }


            for (Ways way : edges) {
                oos1.writeObject(way);
            }


            for (Integer n : bst.keys()) {
                Nodes node3 = bst.get(n);
                for (PoI poI : node3.getPoI()) {
                    oos2.writeObject(poI);
                }
            }

            for (User user : users) {
                oos3.writeObject(user);
            }
        } catch (Exception e) {
            StdOut.println(e);
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                }
                if (oos1 != null) {
                    oos1.close();
                }
                if (oos2 != null) {
                    oos2.close();
                }
                if (oos3 != null) {
                    oos3.close();
                }
            } catch (IOException ioex) {
                StdOut.println(ioex);
            }

        }
    }

    /**
     * Saves to text file
     *
     * @param actionEvent the action event
     */
    public void handleSaveTextFileAction(ActionEvent actionEvent) {
        Out out = new Out(fileSource1);
        Out out1 = new Out(fileSource2);
        Out out2 = new Out(fileSource3);
        Out out3 = new Out(fileSource4);

        out.println(bstSize);
        for (Integer i : bst.keys()) {
            Nodes node = bst.get(i);
            out.print(node.getId() + "," + node.getPoint().getX() + "," + node.getPoint().getY() + "," + node.getVertexID());
            Enumeration<String> e = node.osmNode.keys();
            while (e.hasMoreElements()) {
                String tag = e.nextElement();
                out.print("," + tag + "," + node.osmNode.get(tag));
            }
            out.println();
        }

        out1.println(edgesSize);
        int nodeID1 = 0, nodeID2 = 0;
        for (Ways way : edges) {
            int vertexIDNode1 = way.getV(), vertexIDNode2 = way.getW();
            for (Integer j : bst.keys()) {
                Nodes node1 = bst.get(j);
                if (node1.getVertexID() == vertexIDNode1) {
                    nodeID1 = node1.getId();
                }
                if (node1.getVertexID() == vertexIDNode2) {
                    nodeID2 = node1.getId();
                }
            }
            out1.print(way.getId() + "," + nodeID1 + "," + nodeID2 + "," + way.getWeight());
            Enumeration<String> en = way.osmWay.keys();
            while (en.hasMoreElements()) {
                String tag1 = en.nextElement();
                if (tag1 != null && way.osmWay.get(tag1) != null) {
                    out1.print("," + tag1 + "," + way.osmWay.get(tag1));
                }
            }
            out1.println();
        }

        int size = 0;
        for (Integer m : bst.keys()) {
            Nodes node2 = bst.get(m);
            size += node2.getPoI().size();
        }
        out2.println(size);
        for (Integer n : bst.keys()) {
            Nodes node3 = bst.get(n);
            for (PoI poI : node3.getPoI()) {
                out2.println(poI.getId() + "," + node3.getId() + "," + poI.getName() + "," + poI.getType());
            }
        }

        out3.println(users.size());
        for (User user : users) {
            out3.print(user.getId() + "," + user.getName() + "," + user.getBirthday() + "," + user.getVehicle());
            for (NodeVisited nodeVisited : user.getNodesVisited()) {
                for (PoI poi : nodeVisited.getPoI()) {
                    out3.print("," + "Visited:" + poi.getNodeID() + ":" + poi.getId() + ":" + nodeVisited.getDateVisited().toString());
                }
            }
            out3.println();
        }
        Date d = new Date(29, 4, 2022);
        loadOverpopulatedNodesToFile("data\\overpopulated_nodes_file_txt.txt", 19, 22, d);
        loadGraphToFile("data\\graph_file_txt.txt", d);
        loadNodesVisitToFile("data\\nodes_visit_file_txt.txt", d);
        loadTop5sToFile("data\\top5s_file_txt.txt", d);
    }

    /**
     * Writes Nodes that are overpopulated to a file
     *
     * @param path - The Path
     * @param from - From vertex
     * @param to   - To vertex
     * @param d    - The Date
     */
    public void loadOverpopulatedNodesToFile(String path, int from, int to, Date d) {
        Out out = new Out(path);
        Iterator<Nodes> itr = set.iterator();
        out.println("At this date: " + d.toString() + " there were these overpopulated nodes:");
        while (itr.hasNext()) {
            Nodes node = (Nodes) itr.next();
            out.println("-Node id: " + node.getId());
        }
        shortestPathNotOverpopulated(from, to);
        out.println();
        if (sp.hasPathTo(to)) {
            out.println(sp.pathTo(to));
            out.println("Shortest non overpopulated path from vertex " + from + " to vertex " + to + " is " + sp.distTo(to));
        } else {
            out.println("There's no such path or there's no non overpopulated route.");
        }

        out.println();
        shortestPath(from, to);

        if (sp.hasPathTo(to)) {
            out.println(sp.pathTo(to));
            out.println("Shortest path from vertex " + from + " to vertex " + to + " is " + sp.distTo(to));
        } else {
            out.println("There's no such path.");
        }
    }

    /**
     * Writes Graph to the file
     *
     * @param path - The Path
     * @param d    - The date
     */
    public void loadGraphToFile(String path, Date d) {
        Out out = new Out(path);
        out.println("Check graph connectivity data:");
        if (checkConnectivity() == 0) {
            out.println("The graph is connected.");
        } else {
            out.println("The graph isn't connected.");
        }
        out.println();
        out.println("Check subgraph connectivity data:");

        if (checkSubGraphConnectivity() == 0) {
            out.println("The subgraph is connected.");
        } else {
            out.println("The subgrap isn't connected.");
        }
    }

    /**
     * Writes nodes visited to a file
     *
     * @param path - The Path
     * @param d    - The Date
     */
    public void loadNodesVisitToFile(String path, Date d) {
        Out out = new Out(path);
        ArrayList<PoI> visitedPoI = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();

        out.println("At this date: " + d + " these points of interest were visited by a user:");
        for (User user : users) {
            visitedPoI = visitedBy(d, user);
            out.println("-" + user.getName());
            for (PoI poI : visitedPoI) {
                out.println("---PoI name: " + poI.getName());
            }
        }
        out.println("At this date: " + d + " these points of interest were not visited by any user:");
        Set<String> notVisited = new HashSet<>();
        for (User user : users) {
            visitedBy(d, user);
            for (Integer i : bst.keys()) {
                Nodes node = bst.get(i);
                for (PoI poI : node.getPoI()) {
                    if (!visitedBy(d, user).contains(poI)) {
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
            for (PoI poi : searchNode(nodeKey).getPoI()) {
                out.println("-PoI:" + poi.getName());
                users = whoVisited(d, poi);
                for (User user : users) {
                    out.println("-PoI:" + poi.getName());
                    out.println("---User id: " + user.getId());
                }
            }
        }
        out.println("At this date: " + d + " these points of interest were not visited:");
        for (Integer nodeKey : bst.keys()) {
            for (PoI poi : searchNode(nodeKey).getPoI()) {
                out.println("-PoI id: " + poi.getId());
            }
        }
    }

    /**
     * Writes top 5 PoIs to a file
     *
     * @param path the path
     * @param d    the d
     */
    public void loadTop5sToFile(String path, Date d) {
        Out out = new Out(path);
        ArrayList<User> top5users;
        ArrayList<PoI> top5pois;

        out.println("At this date: " + d + " these are the top 5 users that visited most points of interest:");
        top5users = top5Users(d);
        for (User user : top5users) {
            out.println("-User id: " + user.getId());
        }

        out.println("At this date: " + d + " these are the top 5 points of interest most visited:");
        top5pois = top5PoIs(d);
        for (PoI poI : top5pois) {
            out.println("-PoI id: " + poI.getId());
        }
    }

    /**
     * Handle exit action.
     *
     * @param actionEvent the action event
     */
    public void handleExitAction(ActionEvent actionEvent) {
    }

    /**
     * Reads from binary files
     *
     * @param actionEvent the action event
     */
    public void handleReadBinFileAction(ActionEvent actionEvent) {
        ObjectInputStream ois = null;
        ObjectInputStream ois1 = null;
        ObjectInputStream ois2 = null;
        ObjectInputStream ois3 = null;

        try {
            ois = new ObjectInputStream(new FileInputStream(fileSource5));

            while (true) {
                Nodes node = (Nodes) ois.readObject();
                bst.put(node.getId(), node);
            }

        } catch (Exception e) {
            StdOut.println(e);
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException ioex) {
                StdOut.println(ioex);
            }
        }

        try {
            ois1 = new ObjectInputStream(new FileInputStream(fileSource6));

            while (true) {
                Ways way = (Ways) ois1.readObject();
                edges.add(way);
            }

        } catch (Exception e) {
            StdOut.println(e);
        } finally {
            try {
                if (ois1 != null) {
                    ois1.close();
                }
            } catch (IOException ioex) {
                StdOut.println(ioex);
            }
        }


        try {
            ois3 = new ObjectInputStream(new FileInputStream(fileSource8));

            while (true) {
                User user = (User) ois3.readObject();
                users.add(user);
            }

        } catch (Exception e) {
            StdOut.println(e);
        } finally {
            try {
                if (ois3 != null) {
                    ois3.close();
                }
            } catch (IOException ioex) {
                StdOut.println(ioex);
            }
        }

        afterReadFileAction();
    }

    /**
     * Searches user and displays it
     *
     * @param actionEvent the action event
     */
    public void searchUserBtn(ActionEvent actionEvent) {
        String name = searchFieldName.getText();
        try {
            for (User user : users) {
                if (user.name.equals(name)) {
                    tableView.getItems().clear();
                    tableView.getItems().add(user);
                }
            }

        } catch (Exception e) {
            System.out.println("There's no such user");
        }
    }

    /**
     * Searches Node and displays it
     *
     * @param actionEvent the action event
     */
    public void searchNodeBtn(ActionEvent actionEvent) {
        Integer id = Integer.parseInt(searchFieldNode.getText());
        try {
            for (Integer i : bst.keys()) {
                if (Objects.equals(i, id)) {
                    Nodes node = bst.get(i);
                    tableViewNodes.getItems().clear();
                    tableViewNodes.getItems().add(node);
                }
            }
        } catch (Exception e) {
            System.out.println("There's no such node");
        }
    }

    /**
     * Removes node from the ST and GUI
     *
     * @param actionEvent the action event
     */
    public void removeNodeBtn(ActionEvent actionEvent) {
        Integer id = tableViewNodes.getSelectionModel().getSelectedItem().getId();
        bst.delete(id);
        tableViewNodes.getItems().clear();
        afterReadFileAction();

    }

    /**
     * Adds a node to the ST and GUI
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void addNodeBtn(ActionEvent actionEvent) throws IOException {
        Integer id = Integer.parseInt(nodeidtextfield.getText());

        for (Integer i : bst.keys()) {
            if (id.equals(i)) {
                throw new IOException("Node already exists");
            }
        }

        Integer vertexID = Integer.parseInt(vertexIdTextField.getText());
        Coordinate coordinate = new Coordinate(Double.parseDouble(coordinateXTextField.getText()), Double.parseDouble(coordinateYTextField.getText()));
        String[] text = poiTextField.getText().split(",");
        ArrayList<PoI> poIArrayList = new ArrayList<>();
        for (String s : text) {
            for (Integer x : bst.keys()) {
                Nodes node = bst.get(x);
                for (PoI poi : node.getPoI()) {
                    if (poi.getId().equals(Integer.parseInt(s))) {
                        poIArrayList.add(poi);
                    }
                }
            }
        }
        ArrayList<Ways> waysArrayList = new ArrayList<>();
        text = waysTextField.getText().split(",");
        for (String s : text) {
            for (Ways way : edges) {
                if (Integer.parseInt(s) == way.getId()) {
                    waysArrayList.add(way);
                }
            }
        }

        Hashtable<String, String> ht = new Hashtable<>();
        ht.put(tagTextField.getText(), valueTextField.getText());
        Nodes node = new Nodes(ht, id, vertexID, coordinate, poIArrayList, waysArrayList);
        bst.put(id, node);
        tableViewNodes.getItems().add(node);
    }

    /**
     * Edits node information
     *
     * @param actionEvent the action event
     */
    public void editNodeBtn(ActionEvent actionEvent) {
        try {
            Nodes node = bst.get(Integer.parseInt(nodeidtextfield.getText()));
            node.setVertexID(Integer.parseInt(vertexIdTextField.getText()));
            ArrayList<Ways> waysArrayList = new ArrayList<>();
            String[] text = waysTextField.getText().split(",");
            for (String s : text) {
                for (Ways way : edges) {
                    if (Integer.parseInt(s) == way.getId()) {
                        waysArrayList.add(way);
                    }
                }
            }
            node.setWays(waysArrayList);
            Hashtable<String, String> ht = new Hashtable<>();
            ht.put(tagTextField.getText(), valueTextField.getText());
            node.setOsmNode(ht);
            for (String s : text) {
                for (Integer x : bst.keys()) {
                    Nodes nodes = bst.get(x);
                    for (PoI poi : nodes.getPoI()) {
                        if (poi.getId().equals(Integer.parseInt(s))) {
                            node.setPoI(poi);
                        }
                    }
                }
            }
            Coordinate coordinate = new Coordinate(Double.parseDouble(coordinateXTextField.getText()), Double.parseDouble(coordinateYTextField.getText()));
            node.setPoint(coordinate);
            tableViewNodes.getItems().clear();
            afterReadFileAction();
        } catch (Exception e) {
            System.out.println("Node doesn't exist");
        }
    }

    /**
     * Auxiliar to create a graph
     *
     * @param vNumber
     */
    private void createGraphGroup(int vNumber) {
        createGraph();
        for (int i = 0; i < vNumber; i++) {
            Random r = new Random();
            int radius = 20;

            double posX = radius + r.nextDouble() * 800;
            double posY = radius + r.nextDouble() * 300;

            Circle c = new Circle(posX, posY, radius);
            c.setFill(Color.CORNFLOWERBLUE);
            c.setId("" + i);

            Text text = new Text("" + i);
            StackPane stack = new StackPane();
            stack.setLayoutX(posX - radius);
            stack.setLayoutY(posY - radius);
            stack.getChildren().addAll(c, text);
            graphGroup.getChildren().add(stack);
            //graphGroup.getChildren().add(c);
        }
    }

    /**
     * creates a Graph
     *
     * @param actionEvent the action event
     */
    public void graphBtn(ActionEvent actionEvent) {
        createGraphGroup(getBstSize() + 1);

        for (Ways ways : edges) {
            DirectedEdge edge = new DirectedEdge(ways.getV(), ways.getW(), ways.getWeight());
            StackPane spv = (StackPane) graphGroup.getChildren().get(ways.getV());
            Circle cv = (Circle) spv.getChildren().get(0);
            ewg.addEdge(edge);
            StackPane spw = (StackPane) graphGroup.getChildren().get(ways.getW());
            Circle cw = (Circle) spw.getChildren().get(0);
            Line line = new Line(cv.getCenterX(), cv.getCenterY(), cw.getCenterX(), cw.getCenterY());
            graphGroup.getChildren().add(line);

        }
        System.out.println(ewg);

    }

    /**
     * Searches a Node that contains certain tag
     *
     * @param tag the tag
     * @return array list
     */
    public ArrayList<Nodes> searchTagNodes(String tag) {
        ArrayList<Nodes> nodes = new ArrayList<>();
        for (Integer i : bst.keys()) {
            Nodes node = bst.get(i);
            Enumeration<String> e = node.osmNode.keys();
            while (e.hasMoreElements()) {
                if (Objects.equals(e.nextElement(), tag)) {
                    nodes.add(node);
                }
            }
        }
        return nodes;
    }

    /**
     * Searches a Way that contains certain tag
     *
     * @param tag the tag
     * @return array list
     */
    public ArrayList<Ways> searchTagWays(String tag) {
        ArrayList<Ways> ways = new ArrayList<>();
        for (Ways way : edges) {
            Enumeration<String> e = way.osmWay.keys();
            while (e.hasMoreElements()) {
                if (Objects.equals(e.nextElement(), tag)) {
                    ways.add(way);
                }
            }
        }
        return ways;
    }

    /**
     * Searches a tag near a certain coordinate
     *
     * @param coordinate the coordinate
     * @return hashtable
     */
    public Hashtable<String, String> searchTagNearCoordinate(Coordinate coordinate) {
        ArrayList<Nodes> nodes = new ArrayList<>();
        double small;
        double distance = 0;
        for (Integer i : bst.keys()) {
            Nodes node = bst.get(i);
            small = node.getPoint().calculateDistanceBetweenPoints(node.getPoint().getX(), node.getPoint().getY(), coordinate.getX(), coordinate.getY());
            Nodes node1 = bst.get(i + 1);
            distance = node1.getPoint().calculateDistanceBetweenPoints(node1.getPoint().getX(), node1.getPoint().getY(), coordinate.getX(), coordinate.getY());
            if (distance < small) {
                small = distance;
                nodes.set(0,node1);
            }else{
                nodes.set(0,node);
            }
        }
        return nodes.get(0).getOsmNode();
    }

    /**
     * Max flow from 2 Nodes
     */
    public void maxFlowFrom2Nodes() {
        int s = 0, t = bstSize - 1;
        FlowNetwork G = new FlowNetwork(bstSize, edgesSize);

        FordFulkerson maxflow = new FordFulkerson(G, s, t);
        StdOut.println("Max flow from " + s + " to " + t);
        for (int v = 0; v < G.V(); v++) {
            for (FlowEdge e : G.adj(v)) {
                if ((v == e.from()) && e.flow() > 0) {
                    StdOut.println("   " + e);
                }
            }
        }

        StdOut.print("Min cut: ");
        for (int v = 0; v < G.V(); v++) {
            if (maxflow.inCut(v)) {
                StdOut.print(v + " ");
            }
        }
        StdOut.println();

        StdOut.println("Max flow value =" + maxflow.value());
    }

    /**
     * Calculates the shortest path on click
     *
     * @param actionEvent the action event
     */
    public void shortestPath(ActionEvent actionEvent) {

        int day = shortDate.getValue().getDayOfMonth();
        int month = shortDate.getValue().getMonthValue();
        int year = shortDate.getValue().getYear();
        Date d = new Date(day, month, year);
        overPopulatedNode(d);
        int from = Integer.parseInt(fromID.getText());
        int to = Integer.parseInt(toID.getText());
        shortestPathNotOverpopulated(from, to);
        if (sp.hasPathTo(to)) {
            System.out.println(sp.pathTo(to));
            System.out.println("Shortest non overpopulated path from vertex " + from + " to vertex " + to + " is " + sp.distTo(to));
        } else {
            System.out.println("There's no such path or there's no non overpopulated route.");
        }

        shortestPath(from, to);
        if (sp.hasPathTo(to)) {
            System.out.println(sp.pathTo(to));
            System.out.println("Shortest path from vertex " + from + " to vertex " + to + " is " + sp.distTo(to));
        } else {
            System.out.println("There's no such path.");
        }
    }

    /**
     * R16
     */
    public void newTagValue() {
        String tag = "public_transport";
        for (Integer i : bst.keys()) {
            Nodes node = bst.get(i);
            if (Objects.equals(node.getOsmNode().get(tag), "stop_position")) {
                node.getOsmNode().remove(tag);
                node.getOsmNode().put(tag, "moving_position");
            }
        }
    }


    /**
     * Adds a way to the ST and GUI
     *
     * @param actionEvent the action event
     * @throws IOException the io exception
     */
    public void addWayBtn(ActionEvent actionEvent) throws IOException {
        Integer id = Integer.parseInt(wayIdTextField.getText());
        String name = wayNameTextField.getText();
        int v = Integer.parseInt(wayNodeVTextField.getText());
        int w = Integer.parseInt(wayNodeWTextField.getText());
        double weight = Double.parseDouble(wayWeightTextField.getText());
        String address = addressTextField.getText();
        String postcode = PostCodeTextField.getText();
        String tag = tagWayTextField.getText();
        String value = valueTextField.getText();
        for (Ways way : edges) {
            if (id.equals(way.getId())) {
                throw new IOException("Node already exists");
            }
        }
        Hashtable<String, String> ht = new Hashtable<>();
        ht.put(tag, value);

        Ways way = new Ways(v, w, weight, id, ht, name, address, postcode);
        edges.add(way);
        tableViewNodes1.getItems().add(way);

    }

    /**
     * Edits a way in the ST and GUI
     *
     * @param actionEvent the action event
     */
    public void editWayBtn(ActionEvent actionEvent) {
        try {
            Integer id = Integer.parseInt(wayIdTextField.getText());
            String name = wayNameTextField.getText();
            int v = Integer.parseInt(wayNodeVTextField.getText());
            int w = Integer.parseInt(wayNodeWTextField.getText());
            double weight = Double.parseDouble(wayWeightTextField.getText());
            String address = addressTextField.getText();
            String postcode = PostCodeTextField.getText();
            String tag = tagWayTextField.getText();
            String value = valueTextField.getText();
            Hashtable<String, String> ht = new Hashtable<>();
            ht.put(tag, value);
            for (Ways way : edges) {
                if (Objects.equals(way.getId(), id)) {
                    way.setOsmWay(ht);
                    way.setAddress(address);
                    way.setName(name);
                    way.setPostcode(postcode);
                    tableViewNodes1.getItems().clear();
                    afterReadFileAction();
                }
            }

        } catch (Exception e) {
            System.out.println("Way doesn't exist");
        }
    }

    /**
     * Removes a way from the ST and GUI
     *
     * @param actionEvent the action event
     */
    public void removeWayBtn(ActionEvent actionEvent) {
        Integer id = tableViewNodes1.getSelectionModel().getSelectedItem().getId();
        edges.removeIf(way -> Objects.equals(way.getId(), id));
        tableViewNodes1.getItems().clear();
        afterReadFileAction();
    }

    /**
     * Searches for a Way's ID and displays it
     *
     * @param actionEvent the action event
     */
    public void searchWayBtn(ActionEvent actionEvent) {
        Integer id = Integer.parseInt(searchFieldWay.getText());
        try {
            for (Ways way : edges) {
                if (Objects.equals(way.getId(), id)) {
                    Ways ways = edges.get(edges.indexOf(way));
                    tableViewNodes1.getItems().clear();
                    tableViewNodes1.getItems().add(ways);
                }
            }
        } catch (Exception e) {
            System.out.println("There's no such Way");
        }
    }

    /**
     * Adds a PoI to the Node ArrayList
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    public void addPoiBtn(ActionEvent actionEvent) throws Exception {
        Integer id = Integer.parseInt(poiIDTextField.getText());
        Integer nodeID = Integer.parseInt(nodeIDPOITextField.getText());
        String poiName = PoINameTextField.getText();
        String Vehicle = poiVehicleTextField.getText();

        PoI poi = new PoI(id, nodeID, poiName, Vehicle);

        try {
            for (Integer i : bst.keys()) {
                Nodes node = bst.get(i);
                if (node.getId().equals(nodeID)) {
                    node.setPoI(poi);
                    tableViewPoI2.getItems().clear();
                    afterReadFileAction();
                }
            }

        } catch (Exception e) {
            System.out.println("There's no such Node ID");
        }


    }

    /**
     * Edits a PoI in the Node ArrayList
     *
     * @param actionEvent the action event
     * @throws Exception the exception
     */
    public void editPoIBtn(ActionEvent actionEvent) throws Exception {
        Integer id = Integer.parseInt(poiIDTextField.getText());
        Integer nodeID = Integer.parseInt(nodeIDPOITextField.getText());
        String poiName = PoINameTextField.getText();
        String Vehicle = poiVehicleTextField.getText();
        try {
            for (Integer i : bst.keys()) {
                Nodes node = bst.get(i);
                if (node.getId().equals(nodeID)) {
                    for (PoI poI : node.getPoI()) {
                        if (poI.getId().equals(id)) {
                            poI.setName(poiName);
                            poI.setType(Vehicle);
                            tableViewPoI2.getItems().clear();
                            afterReadFileAction();
                        }
                    }

                }
            }

        } catch (Exception e) {
            System.out.println("There's no such Node ID");
        }
    }

    /**
     * Removes PoI in the node ArrayList
     *
     * @param actionEvent the action event
     */
    public void removePoIBtn(ActionEvent actionEvent) {
        Integer id = tableViewPoI2.getSelectionModel().getSelectedItem().getId();
        for (Integer i : bst.keys()) {
            Nodes node = bst.get(i);
            node.getPoI().removeIf(poi -> Objects.equals(poi.getId(), id));
        }
        tableViewPoI2.getItems().clear();
        afterReadFileAction();
    }
}
