package ru.erma.footballapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.erma.footballapplication.model.Statistics;
@Repository
public interface StatisticsRepository extends JpaRepository<Statistics,Long> {
}
