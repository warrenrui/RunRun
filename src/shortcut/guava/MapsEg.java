package shortcut.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.sun.istack.internal.NotNull;

import java.util.ArrayList;

public class MapsEg {

    public static void main(String[] args) {
        final ArrayList<People> peopleArrayList = new ArrayList<People>();
        peopleArrayList.add(new People("1"));
        peopleArrayList.add(new People("2"));

        /**
         * list转换成不可变map
         */
        final ImmutableMap<String, People> stringPeopleImmutableMap = Maps.uniqueIndex(peopleArrayList, new Function<People, String>() {
            @Override
            public String apply(@NotNull People people) {
                return people.getId();
            }
        });

        System.out.println(JSON.toJSONString(stringPeopleImmutableMap));
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
