class Solution {

    public String encode(List<String> strs) {
        if (strs.isEmpty()){
            return "";
        }
        StringBuilder builder = new StringBuilder();
        StringBuilder constructString = new StringBuilder();
        builder.append(strs.size()).append("|");
        for (String string: strs){
            builder.append(string.length()).append("|");
            constructString.append(string);
        }

        builder.append(constructString);
        return builder.toString();
    }

    public List<String> decode(String str) {
        if (str.isBlank()){
            return Collections.emptyList();
        }
        
        int lastCursor = 0, cursor = 0;
        while (str.charAt(cursor) != '|'){
            cursor++;
        }
        int arrLength = Integer.parseInt(str.substring(lastCursor, cursor));

        List<String> output = new ArrayList<>(arrLength);
        List<Integer> strLengthList = new ArrayList<>(arrLength);
        for (int i = 0; i < arrLength; i++){
            lastCursor = ++cursor;
            while (str.charAt(cursor) != '|'){
                cursor++;
            }

            int strLength = Integer.parseInt(str.substring(lastCursor, cursor));
            strLengthList.add(strLength);
        }

        lastCursor = ++cursor;

        for (int i = 0; i < arrLength; i++){
            cursor+=strLengthList.get(i);
            output.add(str.substring(lastCursor, cursor));
            lastCursor = cursor;
        }

        return output;

    }
}
