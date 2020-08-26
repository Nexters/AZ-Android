# 🤣 AZ-Android 🤣

<img width="600" src="https://user-images.githubusercontent.com/58504556/91311347-f2809580-e7ed-11ea-93a1-00bdb1623dc4.jpg">

안드로이드의 반댓말은? 바깥드로이드

깔깔깔

다들 마음속에 남들에게 꺼내지 못하는 B급 감성의 유머 하나씩 갖고 있지 않나요?

<br>

### 퀴즈! 소나무가 삐지면? 🌲

저희는 그런 분들이 마음놓고 즐길 수 있는 그런 서비스를 준비했어요.

이름하여 AZ (아재트)!!

한글의 아름다움을 살려 B급 감성의 개그를 만나보세요.

하루에 5분, 아니 1분이라도 수 많은 생각을 잠시나마 멈출 수 있는 그런 서비스입니다.

<br>

### 한글의 특징을 살린 B급(레트로) 감성의 개그🧀, 
### 출 퇴근 시간에 조금이나마 🍭엉뚱한 생각🍭을 할 수 있게 도와주는 그런 서비스.

- 눈에 쉽게 들어오는 짧지만 임팩트 있는 재미있는 글을 보여주는 서비스.
- '한글'이 갖춘 언어적 유희를 즐기고, 소개하는 직관적이고 편리한 서비스.
- 소소하지만 은은한 재미를 볼 수 있는 곳, 내가 재밌게 생각하는 말장난을 적을 수 있는 곳.
- 쉽고 간단하게 재밌는 글을 올리고, 다른 사람의 글을 보며 공감하고 웃을 수 있는, 심심할 때 찾는 소통의 공간.

<br>

# 🤖 Android Developer 🤖
- [메인] [올라프](https://github.com/nukeolaf)
- [서브] [모기](https://github.com/KimHunJin)

## 🔨 Android Architecture 🔨
- <strong>Multi Module Programming</strong>
- <strong>Single Activity Architecture (SAA)</strong>
- <strong>Model View ViewModel (MVVM)</strong>

AZ - 아재트 안드로이드 개발팀은 멀티 모듈 형태로 어플리케이션을 개발했습니다.  
멀티 모듈은 코드의 재사용성을 획기적으로 높일 수 있으며, 빌드 속도가 빠르다는 장점이 있습니다.  
또한, 기능별로 코드가 라이브러리화 되면서 코드 간 의존성이 줄어들어  
기존의 Monolithic 구조의 어플리케이션보다 코드의 수정이 용이합니다.  

어플리케이션의 모듈 구조는 대략적으로 다음과 같은 형태로 구성되어있습니다.   

<img width="500" src="https://user-images.githubusercontent.com/58504556/90660575-12113e80-e281-11ea-98a0-ef49f9d8d594.png">

Feature 모듈과 같이 화면 하나로 분류 될 수 있는 기능들은 Dynamic Feature Module 로 만들었습니다.  
DFM 을 사용하면 Google 의 Dynamic Delivery를 통해 사용자가 그때그때 사용할 기능(feature)들만 다운로드 할 수 있어 앱 사이즈를 줄일 수 있기 때문입니다.  
그러나 Core 모듈이나 App 모듈, 그리고 레포지토리에 관련된 모듈들은 Static 하게 구성될 필요가 있어 Android Library Module 로 만들었습니다.  

## Libraries
- AAC Databinding
- AAC Navigation
- AAC LiveData
- AAC Lifecycle
- AAC ViewModel
- Coroutine
- Gson
- Koin
- OkHttp
- Retrofit

<br>
<br>

<img width="200" src="https://user-images.githubusercontent.com/58504556/90659312-7c28e400-e27f-11ea-894e-f9f7733bdd6f.png">

### 정답 : 칫솔~
