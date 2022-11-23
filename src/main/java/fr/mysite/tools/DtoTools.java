package fr.mysite.tools;

import org.modelmapper.ModelMapper;


/**
 * Tool to convert any entity into a Dto and any Dto to a entity
 * @author Jason POQUET
 *
 */
public class DtoTools {

private static ModelMapper myMapper = new ModelMapper();
    
    public static <TSource,TDestination> TDestination convert(TSource obj, Class<TDestination> clazz) {
        return myMapper.map(obj, clazz);
    }
}
