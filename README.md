<div align="center">

# 🧸 Useless and Useful Toys

**쓸데없지만 어쩐지 쓸모 있는 장난감 모드**

![Minecraft](https://img.shields.io/badge/Minecraft-26.3-62B47A?style=flat-square)
![NeoForge](https://img.shields.io/badge/NeoForge-26.3.0.102-E07B39?style=flat-square)
![Java](https://img.shields.io/badge/Java-25-007396?style=flat-square)
![License](https://img.shields.io/badge/License-MIT-blue?style=flat-square)
![Status](https://img.shields.io/badge/status-early%20prototype-lightgrey?style=flat-square)

</div>

---

## 소개

**Useless and Useful Toys**(`useful_toys`)는 NeoForge 기반의 마인크래프트 모드입니다.
진지한 기능보다는 *"이게 되나?"* 싶은 아이디어를 하나씩 블록과 아이템으로 만들어 보는 놀이터입니다.

지금은 **초기 프로토타입** 단계라 블록 하나와 연료 실험 몇 가지만 들어 있습니다.

---

## ✨ 들어 있는 것

### 🟦 테스트 블록

> **정식 명칭**
> 쓸데없이 통통 튀며 레이싱트랙급 속도로 광란의 탱탱함을 자랑하는 얼음-더얼음-개얼음급으로 미끄러운 프랑크푸르트산 세상에서 제일 가는 테스트 블록적인 블록들
>
> *(영문명: Useless Bouncy Speed-Racing Bouncest Ice-Icer-Icest Frankfurt Best of Worldwide Test Blocky Blocks)*

이름 그대로 이것저것 다 넣어 본 블록입니다.

| 속성 | 값 | 설명 |
| --- | --- | --- |
| 밝기 | `12` | 횃불(14)보다 조금 어두운 정도 |
| 점프력 | `×1.1` | 살짝 더 높이 뜀 |
| 반발력 | `1.1` | 통통 튐 |
| 낙하 피해 감소 | `10.0` | 떨어져도 덜 아픔 |
| 마찰 | `1.1` | 미끄러움 (얼음-더얼음-개얼음) |
| 이동 속도 | `×1.1` | 레이싱트랙 |
| 경도 / 폭발 저항 | `1.5` / `6.0` | 돌과 비슷 |
| 채굴 도구 | 괭이 | 올바른 도구가 있어야 드롭 |
| 소리 | 유리 | |
| 노트 블록 악기 | 녹슨 트럼펫 | 아래에 깔면 이 소리가 남 |
| 지도 색 | 파랑 | |

- **외형**: 잎 블록 모델(`minecraft:block/leaves`)에 물 색 틴트(`#3F76E4`)를 입혀 파랗게 보입니다. 블록과 아이템 모두 같은 색입니다.
- **획득 방법**: 크리에이티브 탭 **「자연 블록」**에 있습니다. 서바이벌에서는 아래 제작법으로 만듭니다.

#### 제작법

```
흙 ──[화로 400틱]──▶ 테스트 블록   (+ 경험치 40)
```

흙 한 덩이를 구우면 경험치가 40이나 나옵니다. 왜인지는 묻지 마세요.

### 🔥 연료 실험

바닐라 아이템과 모드 아이템의 연료 성능을 바꿔 봤습니다.

| 아이템 | 연소 시간 | 체감 |
| --- | ---: | --- |
| 테스트 블록 | **2,000,000틱** | 약 27시간 동안 꺼지지 않음 |
| 다이아몬드 | 1,600틱 | 석탄 두 개 분량. 태우지 마세요 |
| 흙 | 1틱 | 불이 붙자마자 꺼짐 |

> 💡 흙 → (굽기) → 테스트 블록 → (연료로 넣기) → 27시간짜리 화로.
> 흙을 무한 연료로 바꾸는 사기급 순환이 이미 완성돼 있습니다.

---

## 🛠️ 개발

### 요구 사항

- **JDK 25**
- Gradle Wrapper가 들어 있으므로 Gradle을 따로 설치할 필요는 없습니다.

### 명령어

| 작업 | 명령 |
| --- | --- |
| 빌드 | `./gradlew build` |
| 클라이언트 실행 | `./gradlew runClient` |
| 서버 실행 | `./gradlew runServer` |
| 게임테스트 서버 | `./gradlew runGameTestServer` |
| 데이터 생성 | `./gradlew runData` |

> Windows에서는 `./gradlew` 대신 `gradlew.bat`을 쓰면 됩니다.

빌드 결과물(`.jar`)은 `build/libs/`에 생성됩니다.
데이터 생성 결과는 `src/generated/resources/`에 저장되고, 자동으로 리소스에 포함됩니다.

### 프로젝트 구조

```
src/main/
├── java/tech/kerupu/useful_toys/
│   ├── UsefulToys.java        # 모드 진입점: 레지스트리 연결, 크리에이티브 탭, 바닐라 아이템 연료 수정
│   ├── ClientEvents.java      # 클라이언트 전용: 블록 틴트 등록
│   ├── blocks/ModBlocks.java  # 블록 정의
│   └── items/ModItems.java    # 아이템 정의 (블록 아이템 + 연료 컴포넌트)
├── resources/
│   ├── assets/useful_toys/    # 블록스테이트, 모델, 아이템 모델, 언어(en_us / ko_kr)
│   ├── data/useful_toys/      # 레시피, 전리품 테이블
│   ├── data/minecraft/tags/   # 괭이 채굴 태그
│   ├── pack.mcmeta
│   └── useful_toys.mixins.json  # 믹스인 설정 (아직 비어 있음)
└── templates/META-INF/
    └── neoforge.mods.toml     # 빌드할 때 gradle.properties 값이 채워짐
```

모드 이름, 버전, 작성자 같은 메타데이터는 `gradle.properties`에서 관리합니다.

---

## 📄 라이선스

[MIT](https://opensource.org/licenses/MIT) © kerupu526
