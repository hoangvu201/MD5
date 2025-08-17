package ra.edu.btvn10.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private Integer id;

    @NotBlank(message = "Tiêu đề không được để trống")
    @Size(max = 100, message = "Tiêu đề tối đa 100 ký tự")
    private String title;

    @NotBlank(message = "Đạo diễn không được để trống")
    @Size(max = 50, message = "Đạo diễn tối đa 50 ký tự")
    private String director;

    @NotNull(message = "Ngày phát hành không được để trống")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releaseDate;

    @NotBlank(message = "Thể loại không được để trống")
    @Size(max = 30, message = "Thể loại tối đa 30 ký tự")
    private String genre;

    @NotBlank(message = "Ảnh áp phích không được để trống")
    private String poster;
}
