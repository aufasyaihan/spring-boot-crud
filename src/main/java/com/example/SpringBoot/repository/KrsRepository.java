package com.example.SpringBoot.repository;

import com.example.SpringBoot.model.Krs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface KrsRepository extends JpaRepository<Krs, Long> {
  public interface KrsProjection {
    String getNim();

    String getKodeMatakuliah();

    String getMatakuliah();

    String getSemester();

    String getTahunakademik();
  }

  @Query(value = "SELECT nim, \"kode matakuliah\" AS kodeMatakuliah, matakuliah, semester, tahunakademik FROM krs ORDER BY id_krs LIMIT :limit", nativeQuery = true)
  List<KrsProjection> findLimited(@Param("limit") int limit);
}
