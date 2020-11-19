package ua.lviv.lgs.zooclub;


import java.util.*;

public class ZooClub {
    Map<String, String> zoomap = new HashMap<>();
    Map<Person, ArrayList<Animal>> map = new HashMap<>();
    public void addPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        Person person = new Person(name,age);
        map.put(person, new ArrayList<Animal>());
        System.out.println(person + "successfully added");
    }
    public void addAnimal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        boolean correct = isZooClubMemberExists(map, name, age);
        if (correct){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name animal: ");
            String nameAnimal = sc.nextLine();
            System.out.println("Enter type of animal: ");
            String type = sc.nextLine();
            Animal animal = new Animal(nameAnimal,type);
            Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<Person, ArrayList<Animal>> nextMember = iterator.next();
                if (nextMember.getKey().getName().equalsIgnoreCase(name)&&nextMember.getKey().getAge() == age){
                    ArrayList<Animal> animals = nextMember.getValue();
                    animals.add(animal);
                    System.out.println(animal.toString()+ " successfully added");
                }
            }
        }

    }
    public void deletedAnimal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        boolean correct = isZooClubMemberExists(map, name, age);
        if (correct){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter name animal: ");
            String nameAnimal = sc.nextLine();
            System.out.println("Enter type of animal: ");
            String type = sc.nextLine();
           boolean correct2 = isZooClubMemberAnimalExists(map,name,age,type,nameAnimal);
           if (correct2){
               Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
               while (iterator.hasNext()){
                   Map.Entry<Person, ArrayList<Animal>> nextMember = iterator.next();
                   if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age){
                       ArrayList<Animal> animalList = nextMember.getValue();

                       Iterator<Animal> iterator2 = animalList.iterator();

                       while (iterator2.hasNext()) {
                           Animal next2 = iterator2.next();

                           if (next2.getTypeOfAnimal().equalsIgnoreCase(type)
                                   && next2.getName().equalsIgnoreCase(nameAnimal)) {
                               iterator2.remove();
                               System.out.println("Animal " + next2.toString() + " successfully deleted "
                                       + nextMember.getKey() + "!");
                           }
                       }
                   }
               }
           }
        }
    }
    public void deletetPerson(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name: ");
        String name = scanner.nextLine();
        System.out.println("Enter age: ");
        int age = scanner.nextInt();
        boolean correct = isZooClubMemberExists(map, name, age);
        if (correct){
            Iterator<Map.Entry<Person,ArrayList<Animal>>> iterator = map.entrySet().iterator();
            while(iterator.hasNext()){
                Map.Entry<Person,ArrayList<Animal>> next = iterator.next();
                if (next.getKey().getName().equalsIgnoreCase(name) && next.getKey().getAge() == age){
                   iterator.remove();
                    System.out.println("Successfully remove!");
                }
            }
        }
    }
    public void removeTypeAnimal(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter type of animal: ");
        String type = scanner.nextLine();
        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

            ArrayList<Animal> animalList = nextMember.getValue();

            Iterator<Animal> iterator2 = animalList.iterator();

            while (iterator2.hasNext()) {
                Animal next2 = iterator2.next();

                if (next2.getTypeOfAnimal().equalsIgnoreCase(type)) {
                    iterator2.remove();
                    System.out.println("Successfully remove!");
                }
            }
        }
    }
    public void sout(){
        Set<Map.Entry<Person, ArrayList<Animal>>> zooClubMembers = map.entrySet();

        System.out.println("ZooClub:");
        for (Map.Entry<Person, ArrayList<Animal>> entry : zooClubMembers) {
            System.out.println("A person " + entry.getKey() + " have " + entry.getValue());
        }
    }
    public void exit(){
        System.exit(0);
    }
    static boolean isZooClubMemberExists(Map<Person, ArrayList<Animal>> map, String name, int age) {
        boolean flag = false;

        Set<Map.Entry<Person, ArrayList<Animal>>> zooClubMembers = map.entrySet();

        for (Map.Entry<Person, ArrayList<Animal>> entry : zooClubMembers) {
            if (entry.getKey().getName().equalsIgnoreCase(name) && entry.getKey().getAge() == age) {
                flag = true;
            }
        }

        return flag;
    }
    static boolean isZooClubMemberAnimalExists(Map<Person, ArrayList<Animal>> map, String name, int age,
                                               String species, String animalName) {
        boolean flag = false;

        Iterator<Map.Entry<Person, ArrayList<Animal>>> iterator = map.entrySet().iterator();

        while (iterator.hasNext()) {
            Map.Entry<Person, ArrayList<Animal>> nextMember = iterator.next();

            if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
                ArrayList<Animal> animalList = nextMember.getValue();

                Iterator<Animal> iterator2 = animalList.iterator();

                while (iterator2.hasNext()) {
                    Animal next2 = iterator2.next();

                    if (next2.getTypeOfAnimal().equalsIgnoreCase(species) && next2.getName().equalsIgnoreCase(animalName)) {
                        flag = true;
                    }
                }
            }
        }

        return flag;
    }
}
