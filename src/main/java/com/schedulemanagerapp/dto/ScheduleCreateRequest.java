@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleCreateRequest {

    @NotBlank(message = "일정 제목은 필수입니다.") // null, "" 둘 다 방지
    @Size(max = 30, message = "일정 제목은 최대 30글자까지 가능합니다.")
    private String title;

    @NotBlank(message = "일정 내용은 필수입니다.")
    @Size(max = 200, message = "일정 내용은 최대 200글자까지 가능합니다.")
    private String description;

    @NotNull(message = "일정 시간은 필수입니다.")
    @Future(message = "현재 시간 이후로만 일정을 등록할 수 있습니다.") // 과거 날짜 방지
    private LocalDateTime scheduleTime;
}