import java.io.*;

public class Main {


    public static boolean checkV(String s) {
        String vowls = "aeiou";
        s = s.toLowerCase();
        if(vowls.contains(s)) {
            return true;
        }
        return false;
    }

    public static boolean checkC(String s) {
        String constanents = "qwrtypsdfghjklzxcvbnm";
        s = s.toLowerCase();
        if(constanents.contains(s)) {
            return true;
        }
        return false;

    }

    public static boolean checkW(String s) {
        String whiteSpace = "\n ";
        if(whiteSpace.contains(s)) {
            return true;
        }
        return false;
    }

    public static void fileFormatting() {


        File file = new File("C:\\Users\\jpsyf\\IdeaProjects\\MarkovLetters\\src\\Bible_KJV.txt");


        try {
            PrintWriter writer = new PrintWriter(
                    "C:\\Users\\jpsyf\\IdeaProjects\\MarkovLetters\\src\\t.txt", "UTF-8");

            BufferedReader br = new BufferedReader(new FileReader(file));

            String s;

            while ((s = br.readLine()) != null) {

                char[] charArray = s.toCharArray();
                for (char ch : charArray) {
                    String temp = Character.toString(ch);

                    if(checkV(temp)) {
                        writer.print("V");
                    } else if (checkC(temp)) {
                        writer.print("C");
                    } else if(checkW(temp)) {
                        writer.print("W");
                    } else {
                        writer.print("P");
                    }
                }
            }
            writer.close();
            br.close();



        } catch ( Exception e ) {
            System.out.println("File not found");
        }
    }

    public static void main(String args[]) {

        //need if using new file
        fileFormatting();

        double vBefore = 0, cBefore = 0, wBefore = 0, pBefore = 0, count = 0;
        double ccBefore = 0, cvBefore = 0, cwBefore = 0, cpBefore = 0, vvBefore = 0, vpBefore = 0, vwBefore = 0,
                ppBefore = 0, pwBefore = 0, wwBefore = 0, vcBefore = 0, pcBefore = 0, pvBefore = 0, wcBefore = 0,
                wvBefore = 0, wpBefore = 0;

        File file = new File("C:\\Users\\jpsyf\\IdeaProjects\\MarkovLetters\\src\\t.txt");

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));

            String s, temp = "", temp1 = "", temp2 = "", real = "";
            int x, y;

            while ((s = br.readLine()) != null) {
                x = 0;
                y =0;
                char[] charArray = s.toCharArray();
                for (char ch : charArray) {
                    if(x != 0) {
                        if(y != 0) {
                            temp2 = temp1;
                        }
                        temp1 = temp;
                        real = temp2 + temp1;
                        y++;
                    }
                    x++;
                    temp = Character.toString(ch);
                    //each individual char below
                    if(temp.equals("V")) {
                        count++;
                        switch (temp1) {
                            case "C":
                                cBefore++;
                                break;
                            case "V":
                                vBefore++;
                                break;
                            case "P":
                                pBefore++;
                                break;
                            case "W":
                                wBefore++;
                                break;
                            default:
                                break;
                        }
                    }

                    if(temp.equals("V")) {
                        switch (real) {
                            case "CC":
                                ccBefore++;
                                break;
                            case "CV":
                                cvBefore++;
                                break;
                            case "CP":
                                cpBefore++;
                                break;
                            case "CW":
                                cwBefore++;
                                break;
                            case "VV":
                                vvBefore++;
                                break;
                            case "VP":
                                vpBefore++;
                                break;
                            case "VW":
                                vwBefore++;
                                break;
                            case "PP":
                                ppBefore++;
                                break;
                            case "PW":
                                pwBefore++;
                                break;
                            case "WW":
                                wwBefore++;
                                break;
                            case "VC":
                                vvBefore++;
                                break;
                            case "PC":
                                vpBefore++;
                                break;
                            case "PV":
                                vwBefore++;
                                break;
                            case "WC":
                                ppBefore++;
                                break;
                            case "WP":
                                pwBefore++;
                                break;
                            case "WV":
                                wwBefore++;
                                break;
                            default:
                                break;
                        }
                    }



                }
            }


            System.out.println("First Order Markov Data\n-----------------------");
            System.out.println("c: " + cBefore/count*100 + "\nv: " + vBefore/count*100 +
                                "\np: " + pBefore/count*100 + "\nw: " + wBefore/count*100);

            System.out.println("\n\nSecond Order Markov Data\n------------------------");
            System.out.println("c: " + (ccBefore+vcBefore+pcBefore+wcBefore)/count*100);
            System.out.println("v: " + (cvBefore+vvBefore+pvBefore+wvBefore)/count*100);
            System.out.println("p: " + (cpBefore+vpBefore+ppBefore+wpBefore)/count*100);
            System.out.println("w: " + (cwBefore+vwBefore+pwBefore+wwBefore)/count*100);


            br.close();
        } catch ( Exception e ) {
            System.out.println("File not found");
        }
    }


}
