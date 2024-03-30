package playaround.other;

import java.lang.reflect.Field;

public class CsvMapper {
    public static void main(String[] args) {
        String csv = "value1,42,3.14";
        String[] mappings = {"field1", "field2", "field3"};
        
        MyPojo pojo = new MyPojo();
        String[] values = csv.split(",");
        
        try {
            for (int i = 0; i < mappings.length; i++) {
                Field field = MyPojo.class.getDeclaredField(mappings[i]);
                field.setAccessible(true);
                if (field.getType() == int.class) {
                    field.set(pojo, Integer.parseInt(values[i]));
                } else if (field.getType() == double.class) {
                    field.set(pojo, Double.parseDouble(values[i]));
                } else {
                    field.set(pojo, values[i]);
                }
            }
        } catch (NoSuchFieldException | IllegalAccessException | IllegalArgumentException e) {
            e.printStackTrace();
        }
        
        System.out.println(pojo.getField1()); // Output: value1
        System.out.println(pojo.getField2()); // Output: 42
        System.out.println(pojo.getField3()); // Output: 3.14

        System.out.println(pojo);
    }
}
