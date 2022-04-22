package primitiveWrapperClass;

import org.junit.jupiter.api.Test;

public class Name {
    private final String name;

    public Name( final String name ) throws IllegalArgumentException{
        this.validateNamingRule( name );
        this.name = name;
    }

    private void validateNamingRule( String name ) throws IllegalArgumentException{
        if ( name.length() <= 0 ) {
            throw new IllegalArgumentException( "[ERROR] 이름은 최소 1글자 이상이여야 합니다." );
        }

        if ( name.length() > 5 ) {
            throw new IllegalArgumentException( "[ERROR] 이름은 5글자까지만 가능합니다." );
        }

        if ( name.indexOf( " " ) > -1 ) {
            throw new IllegalArgumentException( "[ERROR] 이름은 공백이 포함될 수 없습니다." );
        }
    }

    public String showName(){
        return this.name;
    }
}
