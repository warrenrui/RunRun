package shortcut.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class ListsEg {
    public static void main(String[] args) {
        final ArrayList<People> peopleArrayList = new ArrayList<>();
        peopleArrayList.add(new People("1"));
        peopleArrayList.add(new People("2"));
        peopleArrayList.add(new People("3"));
        /**
         * list中对象的某一属性，取出形成新的list
         */
        final List<String> idList = Lists.transform(peopleArrayList, new Function<People, String>() {
            @Override
            public String apply(People people) {
                return people.getId();
            }
        });
        System.out.println(idList.remove("1"));
        System.out.println(JSON.toJSONString(idList));
    }


    static class People {
        private String id;

        People(String id) {
            this.id = id;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
