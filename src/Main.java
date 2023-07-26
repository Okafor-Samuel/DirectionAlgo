import java.util.*;

public class Main {
            public static String[] dirReduc(String[] directions) {
                HashMap<String, String> opposites = new HashMap<>();
                opposites.put("NORTH", "SOUTH");
                opposites.put("SOUTH", "NORTH");
                opposites.put("EAST", "WEST");
                opposites.put("WEST", "EAST");

                Stack<String> stack = new Stack<>();
                for (String direction : directions) {
                    if (!stack.isEmpty() && stack.peek().equals(opposites.get(direction))) {
                        stack.pop();
                    } else {
                        stack.push(direction);
                    }
                }

                return stack.toArray(new String[0]);
            }

            public static void main(String[] args) {
                String[] directions1 = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"};
                String[] optimized1 = dirReduc(directions1);
                System.out.println(Arrays.toString(optimized1)); // Output: [WEST]

                String[] directions2 = {"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH"};
                String[] optimized2 = dirReduc(directions2);
                System.out.println(Arrays.toString(optimized2)); // Output: []

                String[] directions3 = {"NORTH", "WEST", "SOUTH", "EAST"};
                String[] optimized3 = dirReduc(directions3);
                System.out.println(Arrays.toString(optimized3)); // Output: [NORTH, WEST, SOUTH, EAST]
            }
        }
