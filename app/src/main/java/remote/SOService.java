package remote;

/**
 * Created by PriyaPC on 05-04-2017.
 */


import java.util.List;

import gsonStructures.NoticeGSON;
import gsonStructures.StudentGSON;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;

public interface SOService {

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJ1c2VyX25hbWUiOiJzdHVkZW50IiwidHlwZSI6MSwiaWF0IjoxNDg0OTY4ODA3LCJleHAiOjE0OTM2MDg4MDd9.CWbwcLpDLugRRyNeEZtWVujK7TgnIg0-RYb3ob6CYHY")
    @GET("students/list?teacher_id=1")
    Call<List<StudentGSON>> getStudents();

    @Headers("Authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX2lkIjo1LCJ1c2VyX25hbWUiOiJzdHVkZW50IiwidHlwZSI6MSwiaWF0IjoxNDg0OTY4ODA3LCJleHAiOjE0OTM2MDg4MDd9.CWbwcLpDLugRRyNeEZtWVujK7TgnIg0-RYb3ob6CYHY")
    @GET("notices/fetchNotice?school_id=1")
    Call<List<NoticeGSON>> getNotices();
}
