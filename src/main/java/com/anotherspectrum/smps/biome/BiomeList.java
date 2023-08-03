package com.anotherspectrum.smps.biome;

import com.anotherspectrum.smps.api.item.type.Element;

/**
 * 먼저 빛, 어둠 지역 중 서식하는 몬스터의 평균 레벨이 높은 지역은 어둠 지역이다. (빛 < 어둠)
 * <p>따라서 어둠 지역을 제일 마지막에 갈 수 있도록 했다.
 *<p>
 * <p>지역에 따른 몬스터 레벨 순위를 매겨보자면
 * <li>모란 < 모란 수로 < 쿰바 반도 < 카르포티아 산맥 아래 < 산맥의 갈림길 < 카르포티아 정상
 * < 포스타니카 유적 < 옛 왕의 유적 < 아드리아 강 < 광활한 눈길 < 트란실 ... 이다. (아래 열거형 객체의 순서와 동일.)</li>
 * 메인 진행 순서도 위와 같다.
 * <li>하지만, 플레이어가 진행 하면서 무조건 순차적으로 갈 수 있도록 도와줄 필욘 없다.
 * <p>따라서 적은 레벨의 플레이어가 강한 레벨을 필요로 하는 지역에 갈 수 있다는 것이다.
 */
public enum BiomeList {

    NONE("없음", Element.NONE),
    EVENT("이벤트", Element.NONE),

    SKY_VIL("하늘에 닿은 탑 아래", Element.WIND),
    STAR_EATING_SMITHY("별을 먹는 대장간", Element.BRIGHTNESS),

    MORAN("모란의 광활한 평야", Element.EARTH),
    MORAN_MINE("모란 광산", Element.EARTH),
    MORAN_SURO("모란 수로", Element.EARTH),
    KUMBA("쿰바 반도", Element.EARTH), // 보류
    KUMBA_MOUNTAIN("쿰바 산", Element.EARTH),

    KARPOTIA("카르포티아 산맥 아래", Element.WIND),
    KARPOTIA_CROSSROAD("산맥의 갈림길", Element.WIND),
    KARPOTIA_VOLCANO("카르포티아 정상", Element.FIRE),

    /* 거의 찾기 힘든 지역 */
    POSTANICA("포스타니카 유적", Element.LIGHTNING),
    POSTANICA_GORGE("포스타니카 협곡", Element.WIND),
    GRAVE_OF_PREVIOUS_KING("옛 왕의 유적", Element.BRIGHTNESS),
    /*                  */

    ADRIEA("아드리아 강", Element.WATER),
    SNOWIN("광활한 눈길", Element.WATER),
    TRANSIL("트란실", Element.WATER),

    /* 거의 찾기 힘든 지역 */
    BASEMENT_BIG_GRAVE("트란실 지하 큰 묘소", Element.LIGHTNING),
    MORAN_SURO_OF_MIRROR("모란의 반전된 수로", Element.EARTH),
    DARKNESS_HUG_SMITHY("칠흑을 품은 대장간", Element.DARKNESS), // 스토리의 반전 요소가 포함된 지역
    /*                  */

    DEEP_MIRROR("반전된 성역", Element.LIGHTNING),
    DEEP_LIGHT("반전된 빛의 영역", Element.BRIGHTNESS),
    DEEP_PATH("영역의 깊은 곳", Element.DARKNESS),

    ;

    private final String name;
    private final Element elements;

    BiomeList(String name, Element elements) {
        this.name = name;
        this.elements = elements;
    }

    public String getName() {
        return name;
    }

    public Element getElements() {
        return elements;
    }
}
