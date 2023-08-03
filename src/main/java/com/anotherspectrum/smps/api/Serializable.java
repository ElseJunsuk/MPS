package com.anotherspectrum.smps.api;

import java.util.Set;

/**
 * DB에 수록된 데이터를 저장/로드하기 위한 직렬화 인터페이스입니다.
 * <p>저장 담당 자료구조는 {@link Set}<{@link String}> 클래스입니다.</p>
 * <p>로드 시, 제네릭스에 등록된 클래스로 역직렬화하여 로드합니다.</p>
 *
 * @param <T> 역/직렬화 클래스
 */
public interface Serializable<T> {

    Set<String> serialize();

    T deserialize(Set<String> value);

}
