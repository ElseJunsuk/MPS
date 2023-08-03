# MPS
Sententia Management Project
<p>해당 라이브러리는 서버의 아이템, 몬스터, 퀘스트 등을 간편하게 추가할 수 있는 인터페이스를 제공합니다.</p>
<p>또한 해당 라이브러리의 사용 방법을 설명합니다.</p>

## Monster
* 이제 MPS라이브러리에서 서버에 새로운 몬스터를 추가하고 수정할 수 있습니다.
* Monster인터페이스는 SentMonster클래스를 사용하여 확장할 수 있습니다.
### File
* 몬스터 파일 예시
```yaml
# :: Information :: #
# 몬스터의 이름, 설명 등을 설정할 수 있습니다.
# 이름은 플레이어에게 보여질 이름이며 설명은
# 몬스터 도감에 기재됩니다.
information:
  name: "<red>Monster Name"
  description: "<gray>이 몬스터는 예시로 만들어진 몬스터이다.{n}도감에 등록될 설명을 이 곳에 기재한다."

# :: Boss :: #
# 몬스터를 보스로 지정할 수 있습니다.
# 이 경우, 보스 도감에 따로 반영됩니다.
boss:
  enabled: true # 보스몹 설정

# :: Loot :: #
# 드랍 아이템과 경험치, 재화를 설정합니다.
loot:
  exp: "55000~110000"
  items: # 드랍 아이템 설정
    - ITEM_FILE_ONE 1~5 20 # content/items/ITEM_FILE_ONE.yml 파일의 아이템 최소 1개, 최대 5개를 20% 확률로 드랍합니다.

# :: Spawn :: #
# 몬스터의 스폰에 관해 설정할 수 있습니다.
# 스폰 위치, 최대 스폰 개체 수, 스폰 당 마릿수를
# 설정할 수 있습니다.
spawn:
  maxCountLimit: 25 # 최대 몹 개체 수
  spawnCount: 5 # 스폰 당 5마리 스폰
  spawning: # 리스폰 관련 설정입니다.
    cleared: true # 활성화 시 스폰된 몬스터를 모두 잡아야 리스폰 됩니다.
    delay: 100 # 스폰 딜레이 (틱)
  locations: # 스폰 위치에 관한 설정입니다.
    - "122.5 103.0 532.5 random{5.0,0.0,5.0}" # 스폰 X, Y, Z 설정입니다. (random - 설정 좌표 +-좌표입니다.) (인게임 설정 가능.)

# :: Status :: #
# 몬스터의 레벨, 공격력, 방어력 등 여러가지
# 상세 디테일을 설정할 수 있습니다.
status:
  level: 199 # 몬스터의 레벨
  stats: # 물리적인 공격 시에 플레이어에게 미치는 영향에 관한 설정입니다.
    totalAtk: 99000 # 공격력 (방정식을 통해 최종 값이 도출됩니다.)
    defensive: 352 # 방어력 (계산 방식은 공격력과 동일합니다.)
    maxHealth: 54000.00 # 최대 체력
    atkDefensiveIgnore: 35.00 # 방어율 무시
    atkSpeed: 2.5 # 공격 속도
    magic: # 마법 공격에 관한 설정입니다.
      totalMagicAtk: 8800 # 마법 공격력 (공격력 계산 방정식과는 다른 마법 공격력의 방정식을 사용합니다.)
    elements: # 속성에 관한 설정입니다.
      binding: # 몬스터에게 부여된 속성
        - FIRE
        - WIND
      elementDefenses: # 내성 속성 (퍼센테이지(수치) 만큼 무시합니다. 최대: '100')
        - "WATER 50"
        - "FIRE 35"
        - "WIND 20"
      elementPoint: # 약점 속성 (퍼센테이지(수치) 만큼 추가 데미지)
        - "EARTH 20"
        - "BRIGHTNESS 35"
        - "DARKNESS 40"
    effects: # 공격 시 추가적으로 가해지는 디테일 공격(도트, 이펙트 등)을 설정합니다.
      potionEffects: # 포션 효과에 관하여 설정합니다.
        - "spawn{INVISIBILITY 2 40}"
        - "JUMP 2"
    details: # 몬스터의 육체적인 강화를 설정합니다.
      movementSpeed: 2.453 # 이동 속도

# :: Attack :: #
# 몬스터의 공격 방식을 설정합니다.
# 플레이어 발견 유효 범위, 최소 공격 사거리 등을
# 설정할 수 있습니다.
attack:
  findPlayer: 20.0 # 몬스터가 서 있는 위치 기준 20블럭 내에 플레이어를 공격합니다.
  attackRange: 2.0 # 유효 공격 사거리입니다.

# :: Skills :: #
# 몬스터가 특정 이벤트 아래 사용하는 스킬을 설정합니다.
# 상세한 옵션이 존재하며, 모든 이벤트에 관여합니다.
# ! 매직스펠과 연동 가능합니다.
skills:
  spawn: # 몬스터 스폰 시에 발생하는 스킬 리스트입니다.
    - SOME_SKILL 40 2
  scheduler: # 몬스터가 특정 시간(틱)마다 사용하는 스킬 리스트입니다.
    - "hit{SOME_SKILL_TWO 20 2} 1000"
```
* 몬스터 파일 설명

| Section | Key   | Data Type | Required | Default Value | Description                       |
| :------ | :----- | :------- | :---- | :--------- | :------------------------------------ |
| `information` | name | String | true | `NONE` | 몬스터의 이름을 설정합니다.        
| `information` | description | String | true | `NONE` | 몬스터 도감에 기재될 몬스터의 설명입니다. |
| `boss` | enabled | boolean | false | `false` | 해당 몬스터를 보스 몬스터로 지정합니다. |
| `loot` | exp | String | true | `NONE` | 몬스터 처치 시 드랍하는 최소~최대 경험치를 설정합니다. `드랍최소경험치~드랍최대경험치` |
| `loot` | items | String List | false | `NONE` | 몬스터 처치 시 드랍하는 아이템을 설정합니다. `아이템파일이름 드랍최소갯수~드랍최대갯수 드랍확률` |
| `spawn` | maxCountLimit | long | false | `20` | 몬스터가 스폰될 수 있는 최대 마리 수를 설정합니다. (보스 몬스터의 경우 1을 권장합니다.) |
| `spawn` | spawnCount | long | false | `5` | 몬스터의 스폰 마리 수를 설정합니다. (보스 몬스터의 경우 1을 권장합니다.) |
| `spawn` | locations | String List | true | `NONE` | 몬스터가 스폰되는 위치를 설정합니다. |
| `spawn.spawning` | cleared | boolean | false | `true` | 활성화 시 스폰한 몬스터를 모두 처치해야 리스폰합니다. (이 경우, 몬스터 모두 처치 후 딜레이가 시작됩니다.) |
| `spawn.spawning` | delay | long | false | `100` | 몬스터가 스폰되는 딜레이를 설정합니다. |
| `status` | level | long | true | `NONE` | 몬스터의 레벨을 설정합니다. |
| `status.stats` | totalAtk | long | true | `NONE` | 몬스터의 공격력을 설정합니다. |
| `status.stats` | defensive | long | true | `NONE` | 몬스터의 방어력을 설정합니다. |
| `status.stats` | maxHealth | double | true | `NONE` | 몬스터의 최대 체력을 설정합니다. |
| `status.stats` | atkDefensiveIgnore | double | false | `0.00` | 몬스터의 방어율 무시 수치를 설정합니다. (마법 공격이 포함됩니다.) |
| `status.stats` | atkSpeed | double | false | `1.00` | 몬스터의 공격 속도를 설정합니다. (Vanilla 기준 기본 공격만 해당됩니다.) |
| `status.stats.magic` | totalMagicAtk | long | false | false | `0.00` | 몬스터의 마법 공격력을 설정합니다. |
| `status.stats.elements` | binding | Element(String) List | false | `NONE` | 몬스터에게 부여된 속성을 설정합니다. |
| `status.stats.elements` | elementDefenses | Element(String) List | false | `NONE` | 몬스터에게 내성 속성을 추가합니다. `속성이름 무시수치` |
| `status.stats.elements` | elementPoint | Element(String) List | false | `NONE` | 몬스터의 약점 속성을 추가합니다. `속성이름 추가데미지수치(소수)` |
| `status.stats.effects` | potionEffects | String List | false | `NONE` | 몬스터에게 기본적으로 부여된 포션 이펙트를 설정합니다. |
| `status.stats.details` | movementSpeed | double | false | `1.00(Vanilla Default)` | 몬스터의 이동 속도를 설정합니다. |
| `attack` | findPlayer | double | false | `10.00` | 몬스터가 플레이어를 발견하는 거리입니다. (1당 1블럭입니다.) |
| `attack` | attackRange | double | false | `1.00` | 몬스터가 플레이어를 공격하는 유효 사거리입니다. (1당 1블럭입니다.) |
| `skills` | spawn | String List | false | `NONE` | 몬스터 스폰 시 발생하는 스킬을 설정합니다. |
| `skills` | scheduler | String List | false | `NONE` | 몬스터가 특정 시간(틱)마다 사용하는 스킬을 설정합니다. |

## Item


## Quest
