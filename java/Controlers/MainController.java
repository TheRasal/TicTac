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
    String[][] tic={{"0","1","2"},{"3","4","5"},{"6","7","8"}};
    private void random (){
        int a = 0; // Начальное значение диапазона - "от"
        int b = 3; // Конечное значение диапазона - "до"
        int x = a + (int) (Math.random() * b); // Генерация 1-го числа
       int y = a + (int) (Math.random() * b);
        if (!tic[x][y].equals("9")&&!tic[x][y].equals("10")){
            tic[x][y]="10";
        }
        else{
            random();
        }


    }

@RequestMapping(value="/game", method = RequestMethod.POST)
    public String service (HttpServletRequest request, @RequestParam ("") String varX){
    for (int i=0;i<tic.length;i++){
        for (int j=0;j<tic.length;j++){
            if (tic[i][j].equals(varX)){
                tic[i][j]="9";
                random();
                break;
            }
        }
    }




    request.setAttribute("result", tic);
    return "/index.jsp";

}
}
