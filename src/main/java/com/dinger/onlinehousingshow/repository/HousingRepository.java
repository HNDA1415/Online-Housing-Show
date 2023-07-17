package com.dinger.onlinehousingshow.repository;

import com.dinger.onlinehousingshow.entity.Housing;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface HousingRepository extends JpaRepository<Housing,Long> {
    @Query(value = "select h from Housing h " +
            "WHERE h.ownerId=:id AND (:housingName IS NULL OR h.housingName LIKE %:housingName%) " +
            "AND (h.numberOfFloors = :floors) " +
            "AND (h.numberOfMasterRoom = :masterRoom) " +
            "AND (h.numberOfSingleRoom = :singleRoom) " +
            "AND (h.amount = :amount) " +
            "AND (DATE(h.createdDate) = :date)"
            )
    List<Housing> findByUserId(Long id, String housingName, int floors, int masterRoom, int singleRoom, Double amount, Date date);

    @Query("SELECT h FROM Housing h WHERE (:housingName IS NULL OR h.housingName LIKE %:housingName%) " +
            "AND (:floor IS NULL OR h.numberOfFloors = :floor) " +
            "AND (:masterRoom IS NULL OR h.numberOfMasterRoom = :masterRoom) " +
            "AND (:singleRoom IS NULL OR h.numberOfSingleRoom = :singleRoom) " +
            "AND (:amount IS NULL OR h.amount = :amount) " +
            "AND (:timestamp IS NULL OR DATE(h.createdDate) = :timestamp)")
    List<Housing> search(String housingName, int floor, int masterRoom, double amount,int singleRoom, Date timestamp);
}
