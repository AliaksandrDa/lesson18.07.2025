//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.

import java.io.*;
import java.util.Date;

/**
 *   .\\ - эта же дериктория
 *   ..\\ - - на дерикторию выше
 */

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        // ЧТЕНИЕ текстовых файлов:

        FileReader fr = new FileReader(".\\test.txt");
        BufferedReader br = new BufferedReader(fr);
        while (true) {
            String s = br.readLine();
            if (s == null) {
                break;
            } else {
                System.out.println(s);
            }
        }
        br.close();// очистить память от данных этого файла
        fr.close();

        // ЗАПИСЬ текстовых файлов:

        FileWriter fw = new FileWriter("1.txt");   // данный метод создаст файл автоматически, если его нет
        fw.write("Тестовая строка\n");
        fw.write("для поверки работ ");
        fw.write("метода write");
        fw.flush();                                         // этот метод производит запись на дис всех накопленных к записи строк. Это сделано ускорения программы
        fw.close();

        FileWriter fw2 = new FileWriter("2.txt", true);
        BufferedWriter bw = new BufferedWriter(fw2);
        bw.write((new Date()).toString());
        bw.write(" Sasha log in now");
        bw.newLine();
        bw.newLine();
        bw.flush();
        bw.close();
        fw2.close();

        // при каждой компиляции файлы перезаписываются
        // если использовать перегрузку метода с boolean, мы будем не перезаписывать, а добавлять инфу в файл

        // БИНАРНЫЕ ФАЙЛЫ
        // СЕРИЛИЗАЦИЯ или запись бинарного файла
//        FileOutputStream fos = new FileOutputStream("data.bin");
//        ObjectOutputStream oos = new ObjectOutputStream(fos);
//        oos.writeFloat(3.14f);
//        oos.writeBoolean(true);
//        oos.writeChar('!');
//
//        Player Sasch = new Player();
//        Sasch.name = "Sascha";
//        Sasch.setHealth(98.08f);
//        oos.writeObject(Sasch);
//
//        oos.flush();
//        oos.close();
//        fos.close();


        // ДЕСИРИЛИЗАЦИЯ или чтение из бинарного файла

        FileInputStream fis = new FileInputStream("data.bin");
        ObjectInputStream ois = new ObjectInputStream(fis);
        //читается файл в таком же порядке, как и писался. Порядок важен.

        float f = ois.readFloat();
        System.out.println(f);
        ois.readBoolean();
        ois.readChar();
        Player p2 = null;
        try {
            p2 = (Player) ois.readObject();     // метод выдает объект класса Obj нужно его преобразовать в Pl
        } catch (ClassNotFoundException e) {
            System.out.println(e.getCause());
        }
        System.out.println(p2.name);
        System.out.println(p2.getHealth());








    }
}