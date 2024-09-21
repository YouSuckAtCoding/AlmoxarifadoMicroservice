package infnet.edu.atddd.Domain.Enum;

import java.util.HashMap;
import java.util.Map;

public enum Type_Prod {
        Material(1),
        Passeio(2),
        Tosa(3);

        private int value;
        private static Map map = new HashMap<>();
        
        private Type_Prod(int value) {
                this.value = value;
        }

        public int getValue() {
                return value;
        }

        static {
                for (Type_Prod Type_Prod : Type_Prod.values()) {
                        map.put(Type_Prod.value, Type_Prod);
                }
        }

        public static Type_Prod valueOf(int Type_Prod) {
                return (Type_Prod) map.get(Type_Prod);
        }
}
