package test;

import agh.cs.po.lab7.MoveDirection;
import agh.cs.po.lab7.Animal;
import agh.cs.po.lab7.IWorldMap;
import agh.cs.po.lab7.OptionsParser;
import agh.cs.po.lab7.RectangularMap;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OptionsParserTest {

    @Test
    public void parse() {
        IWorldMap map = new RectangularMap(10, 5);
        Animal jaskolka = new Animal(map);
        map.place(jaskolka);
        String moveArr[] = new String[]{"f", "forward", "f", "f"};
        MoveDirection[] movesDir = OptionsParser.parse(moveArr);
        for(MoveDirection moveDir : movesDir)
                jaskolka.move(moveDir);

        assertEquals(jaskolka.toString(),"PosX: 2 PosY: 4 Dir: Północ");

        Animal jaskolka2 = new Animal(map);
        map.place(jaskolka2);
        String moveArr2[] = new String[]{"f", "asd", "asd", "forward", "f", "f"};
        movesDir = OptionsParser.parse(moveArr2);
        for(MoveDirection moveDir : movesDir)
                jaskolka2.move(moveDir);

        assertEquals(jaskolka2.toString(),"PosX: 2 PosY: 4 Dir: Północ");

        Animal jaskolka3 = new Animal(map);
        map.place(jaskolka3);
        String moveArr3[] = new String[]{"r", "right", "left", "r"};
        movesDir = OptionsParser.parse(moveArr3);
        for(MoveDirection moveDir : movesDir)
                jaskolka3.move(moveDir);

        assertEquals(jaskolka3.toString(),"PosX: 2 PosY: 2 Dir: Południe");

    }
}