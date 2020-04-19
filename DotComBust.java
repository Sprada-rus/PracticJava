package bin;
import java.util.*;

public class DotComBust {


	//Объявляем переменные
        private GameHelper helper = new GameHelper();
        private ArrayList<DotCom> dotComsList = new ArrayList<DotCom>();
        private int numOfGuess = 0;

        private void setUpGame(){
            //создаем "Сайты" и присваиваем им адресс
            DotCom one = new DotCom();
            one.setName("Pets.com");
            DotCom two = new DotCom();
            two.setName("Toys.com");
            DotCom three = new DotCom();
            three.setName("wikia.com");
            dotComsList.add(one);
            dotComsList.add(two);
            dotComsList.add(three);

            System.out.println("Цель нашей мисии потопить три корабля с названиями сайтов.");
            System.out.println("Pets.com, Toys.com, wikia.com");
            System.out.println("Нужно их уничтожить используя как можно можно мало боеприпасов");

            for (DotCom dotComSet : dotComsList){
                ArrayList<String> newLocation = helper.placeDotCom(3);
                dotComSet.setLocationCells(newLocation);
            }
        }

        private void startPlaying(){
            while (!dotComsList.isEmpty()){
                String userGuess = helper.getUserInput("Сделайте свой ход");
                checkUserGues(userGuess);
            }
            finishGame();
        }

        private void checkUserGues(String guess) {
            numOfGuess++;

            String result = "Мимо";

            for (DotCom dotComTest : dotComsList) {

                result = dotComTest.checkYourself(guess);
                if (result.equals("Попал")) {
                    break;
                }
                if (result.equals("Потопил")) {
                    dotComsList.remove(dotComTest);
                    break;
                }
            }
            System.out.println(result);
        }

        private void finishGame(){
            System.out.println("Все враги повержаны");
            if (numOfGuess <= 18){
                System.out.println("Отличные показатели всего-то " + numOfGuess + "попыток.");
                System.out.println("Вы смогли сделать так быстро, что мы даже не успели допить свой кофе");
            } else {
                System.out.println("Слишком много и долго вы пытались их уничтожить, это заняло у вас " + numOfGuess + "попыток.");
                System.out.println("Многие умерли от старости, даже я тот кто с вами говорю внук того генерала который вам отдал приказ");
            }
        }

    public static void main(String[] args) {
            DotComBust game = new DotComBust();
            game.setUpGame();
            game.startPlaying();
    }
}

