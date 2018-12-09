package lesson19.zadacha1;

import java.lang.reflect.Field;

/**
 * Created by Hello on 09.12.2018.
 */
public class ReflectoinToString {

    private Object obj;

    public ReflectoinToString(Object obj) {
        this.obj = obj;
    }

    public static String tooString(Object obj){
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        StringBuilder sb = new StringBuilder();
        sb.append(cls.getName()).append(" содержит поля :").append("\n");
        for (int i = 0; i < fields.length; i++) {
            Field field = null;
            try {
                String fieldName = fields[i].getName(); // получаем имя поля
                String fieldType = fields[i].getType().getName(); // получаем тип пол
                sb.append(fieldType).
                    append(" ").
                    append(fieldName);

                field = cls.getDeclaredField(fieldName);
                // устанавливаем модификатор на public
                field.setAccessible(true);
                Object newValueField =  field.get(obj); // получаем значение свойства объекта
                sb.append(" = ").append(newValueField).append("\n");
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (NoSuchFieldException e) {
                    e.printStackTrace();
            }
        }
        return sb.toString();
    }

}
