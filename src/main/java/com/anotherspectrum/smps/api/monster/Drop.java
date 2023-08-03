package com.anotherspectrum.smps.api.monster;

import com.anotherspectrum.anotherlibrary.utils.NumberUtil;
import com.anotherspectrum.smps.api.monster.manager.util.LootItems;

import java.util.List;

/**
 * {@link Monster} 몬스터의 드랍을 설정할 수 있습니다.
 */
public interface Drop {

    // GETTERS

    Long getMinimumMoney();

    Long getMaximumMoney();

    Long getMinimumExp();

    Long getMaximumExp();

    List<LootItems> getItems();

    // SETTERS

    void setMinimumMoney(Long money);

    void setMaximumMoney(Long money);

    void setMinimumExp(Long value);

    void setMaximumExp(Long value);

    void setItems(List<LootItems> items);

    default Long randomExp() {
        return NumberUtil.randomLong(getMinimumExp(), getMaximumExp());
    }

    default Long randomMoney() {
        return NumberUtil.randomLong(getMinimumMoney(), getMaximumMoney());
    }

    @Override
    String toString();

}
