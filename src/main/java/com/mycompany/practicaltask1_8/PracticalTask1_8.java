/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.practicaltask1_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

/**
 *
 * @author User
 */
public class PracticalTask1_8 {

    public static void main(String[] args) {
    HashMap<String,List> dictionaryMap =new HashMap<>();
    dictionaryMap.put("fire", Arrays.asList("огонь", "сжигать", "пламя"));
    dictionaryMap.put("honey", Arrays.asList("мёд"));
    dictionaryMap.put("mean", Arrays.asList("жадный", "подлый", "грубый"));
    dictionaryMap.put("sun",  Arrays.asList("солнце"));
    dictionaryMap.put("right",  Arrays.asList("верно", "направо"));   
    String resultat="";
    int fl=0; //флажок для работы цикла. При необходимости цикл закончит свою работу
    
    while (fl!=3) {
        System.out.println("Выберите действие:");
        System.out.println("1 - Добавить слово в словарь");
        System.out.println("2 - Удалить запись из словаря");
        System.out.println("3 - Прекратить работу");
        Scanner scanner = new Scanner(System.in);
        int action = scanner.nextInt();
        if (action==1){
            System.out.println("введите английское слово ");
            Scanner scanner1 = new Scanner(System.in);
            String english =scanner1.nextLine();
            if (english.matches("[a-zA-Z]+")){
                System.out.println("введите русский перевод слова ");
                Scanner scanner2 = new Scanner(System.in);
                String russian=scanner2.nextLine();
                if (russian.matches("[а-яА-Я]+")){
                    if (dictionaryMap.containsKey(english)){
                        dictionaryMap.put(english, Arrays.asList(dictionaryMap.get(english)+"; " + String.join("", russian)));   
                        TreeMap<String,List> sortedDictionaryMap=new TreeMap<>(dictionaryMap);
                        for(Entry<String,List> entr: sortedDictionaryMap.entrySet()){
                            String engl=entr.getKey();
                            String russi=entr.getValue().toString();
                            russi=russi.replace("[","").replace("]","").replace(",",";");
                            resultat=resultat+engl+"- "+russi+"\n";
                        }
                        System.out.println("Содержимое словаря на данный момент: ");
                        System.out.println(resultat);
                    }else{
                        dictionaryMap.put(english, Arrays.asList(russian));   
                        TreeMap<String,List> sortedDictionaryMap=new TreeMap<>(dictionaryMap);
                        System.out.println("Содержимое словаря на данный момент: ");
                        for(Entry<String,List> entr: sortedDictionaryMap.entrySet()){
                            String engl=entr.getKey();
                            String russi=entr.getValue().toString();
                            russi=russi.replace("[","").replace("]","").replace(",",";");
                            System.out.println(engl+"- "+russi);
                        }
                    }
                }else{
                System.out.println("Введены некорректные данные!");
            }
        }else{
                System.out.println("Введены некорректные данные!");
            }
        }if (action==2){
            System.out.println("Какое английское слово с его переводом Вы бы хотели удалить из словаря? На данный момент в нём следующие слова: ");
               TreeMap<String,List> sortedDictionaryMap=new TreeMap<>(dictionaryMap);
                for(Entry<String,List> entr: sortedDictionaryMap.entrySet()){
                    String engl=entr.getKey();
                    String russi=entr.getValue().toString();
                    russi=russi.replace("[","").replace("]","").replace(",",";");
                    System.out.println(engl+"- "+russi);
                }
            Scanner scanner1 = new Scanner(System.in);
            String english =scanner1.nextLine();
            if (dictionaryMap.containsKey(english)){
               dictionaryMap.remove(english);
               System.out.println("Содержимое словаря на данный момент: ");
               TreeMap<String,List> sortedDictionaryMap1=new TreeMap<>(dictionaryMap);
                for(Entry<String,List> entr: sortedDictionaryMap1.entrySet()){
                    String engl=entr.getKey();
                    String russi=entr.getValue().toString();
                    russi=russi.replace("[","").replace("]","").replace(",",";");
                    System.out.println(engl+"- "+russi);
                }
            }else{
                System.out.println("Вы ошиблись! И Данного слова я не нашел в словаре...");
            }
            
        }if (action==3){
             System.out.println("Вы прекратили редактирование словаря! На данный момент он выглядит так:");
             TreeMap<String,List> sorteDictionaryMap=new TreeMap<>(dictionaryMap);
             for(Entry<String,List> entr: sorteDictionaryMap.entrySet()){
                    String eng=entr.getKey();
                    String russ=entr.getValue().toString();
                    russ=russ.replace("[","").replace("]","").replace(",",";");
                    resultat=resultat+eng+"- "+russ+"\n";
                }
             System.out.println(resultat);
             fl=3;
             break;
            }
        }
}
}