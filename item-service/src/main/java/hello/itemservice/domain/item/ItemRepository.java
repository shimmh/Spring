package hello.itemservice.domain.item;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class ItemRepository {

    //ItemRepository이 싱글톤이며 (스프링은 빈을 싱글톤으로 등록함.) store 변수가 static 이므로
    //멀티 스레드 환경에서 동시에 여러 스레드가 store 객체에 접근하면 데이터가 꼬이므로
    //ConcurrentHashMap, AtomicLong 등을 사용하여야 한다.
    //private static final Map<Long, Item> store = new ConcurrentHashMap<>(); // static
    //private static AtomicLong sequence = new AtomicLong(0L); // static

    private static final Map<Long, Item> store = new HashMap<>();
    private static Long sequence = 0L;

    public Item save(Item item) {
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id) {
        return store.get(id);
    }

    public List<Item> findAll() {
       return new ArrayList<>(store.values());
    }

    public void update(Long itemId, Item updateParam) {
        Item findItem = findById(itemId);

        //프로젝트 규모가 크다면
        //itemName, price, quantity 용 parameterDTO를 만드는게 낫다.
        //개별로 셋해버리면 셋하지 않은 값(id)은 왜 안쓰는 지 혼랑스럽기에
        //객체로 만들어서 update하는것이 깔끔하다.
        findItem.setItemName(updateParam.getItemName());
        findItem.setPrice(updateParam.getPrice());
        findItem.setQuantity(updateParam.getQuantity());
    }

    public void clearStore() {
         store.clear();
    }
}
