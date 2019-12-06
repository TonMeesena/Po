import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


class Graph {


        private static Map<String, List<String>> adjVertices;

        Graph(){
            adjVertices=new HashMap<String, List<String>>();
        }

        public static void put(String a){

            List<String> b= new LinkedList<>();
            adjVertices.put(a,b);
        }


        public static void put(String a, String b){

            adjVertices.get(a).add(b);
            adjVertices.get(b).add(a);
        }
        public static List<String> get(String a){
            return adjVertices.get(a);
        }

        public Map getMap(){
            return adjVertices;
        }

    }

