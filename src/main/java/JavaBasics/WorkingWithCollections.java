package JavaBasics;


import java.util.*;

import static org.apache.commons.io.filefilter.FileFilterUtils.filterList;

public class WorkingWithCollections {
    public static void main(String[] args) {

        List<String> check = new ArrayList<String>();
        ArrayList<String> test = new ArrayList<>();

        check.add("1");
        check.add("2");
        check.add("3");
        check.add("4");
        System.out.println(check);

        Iterator<String> itr = check.iterator();
        while (itr.hasNext()) {
            String ele = itr.next();
            if (ele.equals("1")) {
                itr.remove();
            }
        }
        System.out.println(check);

        check.removeIf("2"::equals);
        System.out.println(check);

        ArrayList<String> sorting = new ArrayList<>();
        sorting.add("c");
        sorting.add("d");
        sorting.add("H");
        sorting.add("a");
        sorting.add("x");
        sorting.add("G");
        Collections.sort(sorting);
        Collections.sort(sorting, Collections.reverseOrder());
        Collections.sort(sorting, String.CASE_INSENSITIVE_ORDER);
        System.out.println(sorting);


        ArrayList<String> sortingg = new ArrayList<>();
        sortingg.add("11");
        sortingg.add("22");
        sortingg.add("234");
        sortingg.add("44");
        sortingg.add("1");
        sortingg.add("2");
        Collections.sort(sortingg);
        System.out.println(sortingg);

        ArrayList<Integer> oddNum = new ArrayList(Arrays.asList(1, 3, 2, 7, 7, 7, 9, 4, 8, 9, 1, 1));
  /*      Iterator<Integer> itrr = oddNum.iterator();
        while (itrr.hasNext()) {
            int x = (Integer)itrr.next();
            if(x % 2 != 0){
                itrr.remove();
            }
        }
        System.out.println(oddNum); */

        //second option
        oddNum.removeIf(elem -> elem % 2 != 0);
        System.out.println(oddNum);

        Map<String, ArrayList<Integer>> eve = new HashMap<String, ArrayList<Integer>>();
        eve.put("someKey", oddNum);
        eve.put("someKey2", oddNum);
        eve.put("Andrea",  new ArrayList(Arrays.asList(22,11,33)));
        System.out.println(eve);

        for (Map.Entry<String, ArrayList<Integer>> entry: eve.entrySet()){
            System.out.println(entry.getKey() + ": " + entry.getValue());

        }
    }





}

