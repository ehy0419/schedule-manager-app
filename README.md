# 📘 프로젝트 이름

이 프로젝트는 일정 관리 시스템을 위한 CRUD 기능을 제공합니다.

# 📌 프로젝트 개요
- 이 프로젝트는 일정 관리 시스템의 일정 생성 기능을 구현합니다. 사용자는 일정 제목, 내용, 작성자명, 비밀번호를 입력하여 일정을 생성할 수 있으며, 작성일과 수정일은 자동으로 기록됩니다.

🗂️ 패키지 구조
- src/<br>
└── main/<br>
  └── java/<br>
    └── com/example/schedule/<br>
      ├── controller/<br>
      ├── dto/<br>
      ├── entity/<br>
      ├── repository/<br>
      └── service/<br>

🧾 ERD (Entity Relationship Diagram)

| 필드명      | 타입           | 설명                                              |
|------------|----------------|---------------------------------------------------|
| `id`       | `Long`         | 일정 고유 식별자 (PK)                             |
| `title`    | `String`       | 일정 제목                                         |
| `content`  | `String`       | 일정 내용                                         |
| `author`   | `String`       | 작성자명                                          |
| `password` | `String`       | 일정 비밀번호 (저장은 하지만 응답에는 포함되지 않음) |
| `createdAt`| `LocalDateTime`| 작성일 (JPA Auditing 적용)                        |
| `modifiedAt`| `LocalDateTime`| 수정일 (JPA Auditing 적용)                       |

⚙️ `createdAt`과 `modifiedAt`은 **JPA Auditing**을 통해 자동으로 관리됩니다.

---

## 📮 일정 생성 API

### ✅ POST `/api/schedules`
- 일정 생성 요청을 처리합니다.

### 📥 Request Body (JSON)
```json
{
  "title": "회의 일정",
  "content": "팀 회의 진행",
  "author": "홍길동",
  "password": "1234"
}
```

📤 Response Body (JSON)
```json
{
  "id": 1,
  "title": "회의 일정",
  "content": "팀 회의 진행",
  "author": "홍길동",
  "createdAt": "2025-08-01T16:30:00",
  "modifiedAt": "2025-08-01T16:30:00"
}
```

🔒 password는 응답에 포함되지 않습니다.

# 🛠️ 기술 스택 및 설정
- Spring Data JPA
- Spring Web
- JPA Auditing
- MySQL
- Lombok

# 📌 향후 개발 예정
- 일정 조회 (GET)
- 일정 수정 (PUT)
- 일정 삭제 (DELETE)
- 비밀번호 검증 로직 추가
- 예외 처리 및 응답 포맷 통일

## ✅ 기능 목록
- 일정 생성
- 일정 조회
- 일정 수정
- 일정 삭제

## 🗂️ 기술 스택
- Spring Boot
- JPA
- IntelliJ IDEA