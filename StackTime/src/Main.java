public class Main {
    public static void main(String[] args) {
        stack.push('a');
        stack.push('b');
        stack.push('c');
        reverse();

    }
    //helper function
    public static boolean isConsonant(char ch){
        ch = Character.toUpperCase(ch);

        return !(ch == 'A' || ch == 'E' ||
                ch == 'I' || ch == 'O' ||
                ch == 'U') && ch >= 65 && ch <= 90;
    }
    public static int totalConsonants(String str){
        int count = 0;
        for (int i = 0; i < str.length(); i++)

            // To check is character is Consonant
            if (isConsonant(str.charAt(i)))
                ++count;
        return count;
    }

    public static int countSubstrs(String str, int i,
                                   int j, int n){
        // base cases
        if (n == 1)
            return 1;
        if (n <= 0)
            return 0;

        int res = countSubstrs(str, i + 1, j, n - 1) +
                countSubstrs(str, i, j - 1, n - 1) -
                countSubstrs(str, i + 1, j - 1, n - 2);

        if (str.charAt(i) == str.charAt(j))
            res++;

        return res;

    }
    static LinkedStack<Character>stack=new LinkedStack<>();
    public static void insert_at_bottom(char x){

        if(stack.isEmpty())
            stack.push(x);
        else{
            char a=stack.top();
            stack.pop();
            insert_at_bottom(x);
            stack.push(a);
        }
    }
    public static void reverse(){
        if(!stack.isEmpty()){
            char x=stack.top();
            stack.pop();
            reverse();
            insert_at_bottom(x);
        }



    }
}