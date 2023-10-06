package org.example.ch10.jpql.udf;

import org.hibernate.dialect.PostgreSQL10Dialect;
import org.hibernate.dialect.function.StandardSQLFunction;
import org.hibernate.type.StandardBasicTypes;

public class MyPostgresDialect extends PostgreSQL10Dialect {
    public MyPostgresDialect(){
        registerFunction("concat_name", new StandardSQLFunction
                ("concat_name", StandardBasicTypes.STRING)
        );
    }
}
