import java.util.HashMap;

public class Anagram {

    public static void main(String[] args) {
        
        String s1 = "evilae";
        String s2 = "aevile";
        
        Boolean result = isAnagram(s1, s2);
        
        System.out.println(result);

    }

    private static Boolean isAnagram(String s1, String s2) {
        
        if(s1.length() != s2.length()){
            return false;
        }
        
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        
        //Populate map with s1
        for (int i = 0; i < s1.length(); i++) {
            char charOfs1 = s1.charAt(i);
            if(map.containsKey(charOfs1)){
                map.put(charOfs1, map.get(charOfs1)+1);    
            } else {
                map.put(charOfs1, 1);
            }
        }
        
        //Check map contains s2 chars. If map contains char, decrease value of the char by 1.
        for(int i = 0 ; i < s2.length() ; i++){
            
            char charOfs2 = s2.charAt(i);
            if(map.containsKey(charOfs2)){
                map.put(charOfs2, map.get(charOfs2)-1);
            } else {
                return false;
            }
        }
        
        //Check every value of map are 0.
        for(int value : map.values()){
            if(value != 0){
                return false;
            }
        }
        
        return true;
        
    }

}


