public class BowlingGame {

   private int getBowlingScore(String str) {
        int score = 0;
        String[] shuang = str.split("\\|\\|");
        int lastBuChong = 0;
        if (shuang.length>1)
            lastBuChong = getLastScore(shuang[1]);

        String[] fen = shuang[0].split("\\|");

        for (int i=0;i<=7;i++){
            int ge = getGeSocre(fen[i],fen[i+1],fen[i+2]);
            score+=ge;
        }

        if (fen[8].equals("X")&&fen[9].equals("X"))
            score+=20+getSingle(shuang[1].charAt(0));
        else if (fen[8].equals("X")&&!fen[9].equals("X")){
            score+=10+getLastScore(fen[9]);
        }else {
            score += getLastScore(fen[8]);
            if (fen[8].charAt(1)=='/'){
                score+=getSingle(fen[9].charAt(0));
            }
        }

        score+=getLastScore(fen[9]);

        score+=lastBuChong;


        return score;
    }

    private int getGeSocre( String str1, String str2, String str3) {
        int score = 0;
        if (str1.equals("X")&&str2.equals("X")){
            score+=20+getLastScore(str3);
        }else if (str1.equals("X")&&!str2.equals("X")){
            score+=10+getLastScore(str2);
        }else {
            score += getLastScore(str1);
            if (str1.charAt(1)=='/'){
                score+=getSingle(str2.charAt(0));
            }
        }

        return score;
    }

    private static int getSingle(char c) {
        if (c=='-')
            return 0;
        else if (c=='X')
            return 10;
        else
            return Character.getNumericValue(c);
    }


    private int getLastScore(String str) {
        int lastScore = 0;
        if (str.length()==1){
            if (str.charAt(0)=='-')
                return 0;
            else if (str.charAt(0)=='X')
                return 10;
            else
                return Character.getNumericValue(str.charAt(0));
        }else {
            char one = str.charAt(0);
            char two = str.charAt(1);
            if (one=='-')
                lastScore+=0;
            else if (one=='X')
                lastScore+=10;
            else
                lastScore+=Character.getNumericValue(one);

            if (two=='-')
                lastScore+=0;
            else if (two=='X')
                lastScore+=10;
            else if (two=='/')
                lastScore=10;
            else
                lastScore+=Character.getNumericValue(two);

        }
        return lastScore;
    }
}
