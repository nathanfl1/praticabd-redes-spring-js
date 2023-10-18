package com.redes.praticabdredes.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.tomcat.util.json.JSONParser;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.redes.praticabdredes.model.Dispositivo;

@RestController
public class DispositivoController {
    private JdbcTemplate template;
    @PostMapping("/api/cadastrar")
    public ResponseEntity<String> cadastrar(@RequestBody String jsonStr) {
        try {
            JSONParser parser = new JSONParser(jsonStr);
            LinkedHashMap<String, Object> json = parser.object();

            for (Dispositivo d : listaDispositivos()) {
                if (d.getMac().equals(json.get("mac")) || d.getIp().equals(json.get("ip"))) {
                     return new ResponseEntity<String>("MAC ou IP já existem!", HttpStatus.BAD_REQUEST);
                }
                else
                    System.out.println(d.getMac());
            }
            String sql = queryInsert(json);
            template.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }


        return new ResponseEntity<String>("Dispositivo cadastrado!", HttpStatus.CREATED);
    }


    public DispositivoController(JdbcTemplate template) {
        this.template = template;
    }


    public String queryInsert(LinkedHashMap<String, Object> json)
    {
        String sql = "INSERT INTO dispositivo(nome, mac, ip, descricao, localizacao, tipo) VALUES(";
        sql += "'" + json.get("nome") +  "',";
        sql += "'" + json.get("mac") +  "',";
        sql += "'" + json.get("ip") +  "',";
        sql += "'" + json.get("descricao") +  "',";
        sql += "'" + json.get("localizacao") +  "',";
        sql += "'" + json.get("tipo") +  "')";
        return sql;
    }

    public List<Dispositivo> listaDispositivos(){
       return template.query("SELECT * FROM dispositivo p", new RowMapper<Dispositivo>() {
        @Override
        public Dispositivo mapRow(ResultSet rs, int rownumber) throws SQLException {
            Dispositivo e = new Dispositivo();
            e.setNome(rs.getString(2));
            e.setMac(rs.getString(3));
            e.setIp(rs.getString(4));
            e.setDescricao(rs.getString(5));
            e.setLocalizacao(rs.getString(6));
            e.setTipo(rs.getString(7));
          return e;
        }
      });
    }
    @GetMapping("/api/lista")
    public List<Dispositivo> listaDispositivosOrdenada(){
       return template.query("SELECT * FROM dispositivo p ORDER BY p.tipo", new RowMapper<Dispositivo>() {
        @Override
        public Dispositivo mapRow(ResultSet rs, int rownumber) throws SQLException {
            Dispositivo e = new Dispositivo();
            e.setNome(rs.getString(2));
            e.setMac(rs.getString(3));
            e.setIp(rs.getString(4));
            e.setDescricao(rs.getString(5));
            e.setLocalizacao(rs.getString(6));
            e.setTipo(rs.getString(7));
          return e;
        }
      });
    }
}
