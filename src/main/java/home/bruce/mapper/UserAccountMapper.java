package home.bruce.mapper;

import home.bruce.bean.UserAccount;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserAccountMapper {
    UserAccount selectById(long id);

    List<UserAccount> selectAll();

    // 多個參數，可用三種方式
    // 使用 arg0 arg1，從 0 開始，這種方式「不可」搭配 @Param
    // param1 param2，從 1 開始，這種方式「可」搭配 @Param
    // argN 和 paramN 可以混用
    // 使用 @Param
//    UserAccount selectByIdAndName(long id, String name);
    UserAccount selectByIdAndName(@Param("id") long id, @Param("name") String name);

    // 傳 map 後，只能使用自定義的 key，不能再搭配 argN、paramN、@Param
    // 還是可以用 @Param，這時 xml 就要用 m.mapKey
    UserAccount selectByMap(@Param("m") Map<String, Object> map);

    // 會調用 getter/setter 方法
    UserAccount selectByBean(UserAccount userAccount);

    @MapKey("name") // 如果沒有這個註解，那回傳的結果是 Map；如果有這個註解，那 key 就是設定的對應值，value 為 Map，但注意要選不會重覆的欄位，因為 map 的 key 重覆，值會覆蓋
    // 假設 sql 回傳多條資料，可用 List<Map<String, Object>> 或者用 @MapKey 來接收
    Map<String, Map<String, Object>> returnMap();
//    Map<String, Object> returnMap();

    List<UserAccount> selectLike(String name);

    int insertOne(UserAccount userAccount);
}