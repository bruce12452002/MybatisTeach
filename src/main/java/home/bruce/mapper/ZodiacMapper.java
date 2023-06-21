package home.bruce.mapper;

import home.bruce.bean.Zodiac;

import java.util.List;

public interface ZodiacMapper {
    List<Zodiac> selectAll();

    List<Zodiac> selectAllWithResultMap();

}