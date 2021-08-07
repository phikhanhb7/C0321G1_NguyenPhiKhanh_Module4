package com.example.model.repository.contract;

import com.example.model.entity.contract.Contract;
import com.example.model.entity.contract.ContractTotal;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {
        @Query(value=" select  * from  contract where flag =0 ", nativeQuery= true ,
                countQuery = "select  count(*) from  contract where flag =0")
        Page<Contract> findAll(Pageable pageable);

//        @Query(value= "select contract.id,c.customer_name,contract.contract_start_day,contract.contract_end_day, " +
//                "sum(s.service_cost+ dt.quantity* att.attach_service_cost) as contract_total " +
//                " from contract " +
//                " join services s on s.id = contract.service_id " +
//                " join contract_detail dt on contract.id = dt.contract_id" +
//                " join attach_service att on att.id = dt.attach_service_id" +
//                " join customer c on contract.customer_id= c.id " +
//                " where (now() between contract.contract_start_day and contract.contract_end_day) " +
//                " and (c.customer_name like %?1%)" , nativeQuery =true)
//        Page<ContractTotal> findAllContractUsing(String name, Pageable pageable);

        @Query(value = "select * from contract " +
                "join customer on customer.id = contract.customer_id " +
                "where (current_date() between contract.contract_start_day and contract.contract_end_day) " +
                "and customer.customer_name like %?1% " +
                " and contract.flag = false " , nativeQuery = true )
        Page<Contract> findAllContractUsing(String name , Pageable pageable);
}


//<td>#</td>
//<td>contract ID</td>
//<td>Customer Name</td>
//<td>Start  Day</td>
//<td>Total Money</td>
//<td>End Day</td>
//<td>Service</td>
//<td>Attach service</td>