package com.Api.CronCargaDatos.Repository;

import com.Api.CronCargaDatos.Model.Comercio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComercioRepository extends JpaRepository<Comercio,Long> {
}
