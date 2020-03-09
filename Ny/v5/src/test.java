public class test {
    public static void main(String[] args) {
        System.out.println(reversedString("brah"));
    }
    public static String reversedString(String str) { 				//denna metoden tar in en string, skapar en string och skriver sedan om stringen baklänges. Sist returnerar man "result".
        String result = "";

        for (int i = str.length() - 1; i >= 0; i--) {					//problemet med denna kod är att man lägger till stringen man tog in, fast baklänges i samma string.
            result += str.charAt(i);									//Man använder alltså inte "result". Vad man borde göra istället är att man lägger till char till result.
        }
        return result;
    }
}
