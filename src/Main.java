//TIP 코드를 <b>실행</b>하려면 <shortcut actionId="Run"/>을(를) 누르거나
// 에디터 여백에 있는 <icon src="AllIcons.Actions.Execute"/> 아이콘을 클릭하세요.
public class Main {
    public static void main(String[] args) {
        int a = 3, b = 3, c = 3;
        b = a++;
        System.out.println(b + "/" + a );
        a = ++b;
        System.out.println(a + "/" + b );
        a = c--;
        System.out.println(a + "/" + c );
        b = --c;
        System.out.println(b + "/" + c );
    }
}