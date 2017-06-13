package Controlers;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.io.PipedOutputStream;
import java.util.Random;

@Controller
@RequestMapping("/tictak")
public class MainController {
   private static String winner;

    String[][] tic={{"0","1","2"},{"3","4","5"},{"6","7","8"}};

    private void random (){
        int r=0;
        for (int i=0;i<tic.length;i++) {
            for (int j = 0; j < tic.length; j++) {
                if (!tic[i][j].equals("9")&&!tic[i][j].equals("10")){
                    r++;
                }

            }
        }
        int a = 0; // Начальное значение диапазона - "от"
        int b =3; // Конечное значение диапазона - "до"
        int x = a + (int) (Math.random() * b); // Генерация 1-го числа
       int y = a + (int) (Math.random() * b);

        if (!tic[x][y].equals("9")&&!tic[x][y].equals("10")){
            tic[x][y]="10";
        }
        else{if(r!=0) {
            random();
        }
        }
    }
    private boolean winner(){
        int r=0;
        for (int i=0;i<tic.length;i++) {
            for (int j = 0; j < tic.length; j++) {
                if (!tic[i][j].equals("9")&&!tic[i][j].equals("10")){
                    r++;
                }

            }
        }
       if ((tic[0][0].equals("9")&&tic[0][0].equals(tic[0][1])
               &&tic[0][0].equals(tic[0][2]))||(tic[0][1].equals("9")&&tic[0][1].equals(tic[1][1])
               &&tic[0][1].equals(tic[2][1]))||(tic[0][0].equals("9")&&tic[0][0].equals(tic[1][0])
       &&tic[0][0].equals(tic[2][0]))||(tic[0][2].equals("9")&&tic[0][2].equals(tic[1][2])
               &&tic[0][2].equals(tic[2][2]))||(tic[2][0].equals("9")&&tic[2][0].equals(tic[2][1])
               &&tic[2][0].equals(tic[2][2]))||(tic[2][0].equals("9"
       )&&tic[2][0].equals(tic[1][1])&&tic[2][0].equals(tic[0][2]))||(tic[0][0].equals("9"
       )&&tic[0][0].equals(tic[1][1])&&tic[0][0].equals(tic[2][2]))){
           winner="Вы Победили";

        return true;
       }else if ((tic[0][0].equals("10")&&tic[0][0].equals(tic[0][1])
               &&tic[0][0].equals(tic[0][2]))||(tic[0][1].equals("10")&&tic[0][1].equals(tic[1][1])
               &&tic[0][1].equals(tic[2][1]))||(tic[0][0].equals("10")&&tic[0][0].equals(tic[1][0])
                &&tic[0][0].equals(tic[2][0]))||(tic[0][2].equals("10")&&tic[0][2].equals(tic[1][2])
                &&tic[0][2].equals(tic[2][2]))||(tic[2][0].equals("10")&&tic[2][0].equals(tic[2][1])
                &&tic[2][0].equals(tic[2][2]))||(tic[2][0].equals("10"
        )&&tic[2][0].equals(tic[1][1])&&tic[2][0].equals(tic[0][2]))||(tic[0][0].equals("10"
        )&&tic[0][0].equals(tic[1][1])&&tic[0][0].equals(tic[2][2]))){
           winner="Победа за компьютером";
           return true;


       }else if (r==0){
            winner="ничья";
            return true;
       }
        return false;
    }

@RequestMapping(value="/game", method = RequestMethod.POST)
    public String service (HttpServletRequest request, @RequestParam ("") String varX){
    for (int i=0;i<tic.length;i++){
        for (int j=0;j<tic.length;j++){
            if (tic[i][j].equals(varX)){
                tic[i][j]="9";
                if(!winner()){
                    random();
                }
                winner();
                break;
            }
        }
    }
    if (winner()){
        request.setAttribute("winner", winner);

    }



request.setAttribute("win", winner());
    request.setAttribute("result", tic);
    return "/index.jsp";

}
}
