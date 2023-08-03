package com.anotherspectrum.smps.api.monster;

/**
 * {@link Monster} 몬스터의 상세한 스테이터스를 수정합니다.
 * <p>이는 포션 효과, 이동 속도, 공격력 등이 포함됩니다.</p>
 */
public interface MonsterModified {

    double damage();

    double moveSpeed();

}
