package com.jett.demo5;

public class App {
    public static void main(String[] args) {
//        for (Category cate: Category.values()) {
//            System.out.println(cate.getId());
//            System.out.println(cate.name());
//            System.out.println(cate.toString());
//            System.out.println(cate.ordinal());
//        }

//        System.out.println(Category.TB);
        Person person = new Person() {
            @Override
            public void run() {

            }

            @Override
            public boolean hasGrilFriend(String name) {
                return false;
            }
        };

        boolean has = person.hasGrilFriend("pengjintao");

        System.out.println(has);
    }
}
