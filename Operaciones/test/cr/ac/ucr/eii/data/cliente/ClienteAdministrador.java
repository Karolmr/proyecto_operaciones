package cr.ac.ucr.eii.data.cliente;

import cr.ac.ucr.eii.data.DB.DBUtil;
import cr.ac.ucr.eii.data.Data.DatoAdministrador;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Mauricio Andrés Zamora Hernández
 */
public class ClienteAdministrador extends DatoAdministrador<Cliente> {

    @Override
    protected void cargarDatoDelResultSet(Cliente dato, ResultSet rs) throws Exception {
        dato.setnombre(rs.getString("nombre"));
        dato.setcedula(rs.getString("cedula"));
        dato.settelefono(rs.getString("telefono"));
        dato.setcorreo(rs.getString("correo"));
        dato.setcodigo(DBUtil.getInteger(rs, "codigo"));
        dato.setcomentario(rs.getString("comentario"));
        dato.setclasificacion(rs.getString("clasificacion"));
        dato.setdireccion(rs.getString("direccion"));
    }

    @Override
    protected Cliente crearDato() {
        return new Cliente();
    }

    @Override
    protected String crearSQLCreacion() {
        return "insert into cliente (codigo, cedula, nombre, direccion, telefono, correo, clasificacion, comentario) values (?, ?, ?, ?, ?, ?, ?, ?)";
    }

    @Override
    protected void cargarParametrosSQLCreacion(PreparedStatement ps, Cliente dato) throws Exception {
        DBUtil.setInteger(ps, 1, dato.getcodigo());
        DBUtil.setString(ps, 2, dato.getcedula());
        DBUtil.setString(ps, 3, dato.getnombre());
        DBUtil.setString(ps, 4, dato.getdireccion());
        DBUtil.setString(ps, 5, dato.gettelefono());
        DBUtil.setString(ps, 6, dato.getcorreo());
        DBUtil.setString(ps, 7, dato.getclasificacion());
        DBUtil.setString(ps, 7, dato.getcomentario());
    }

    @Override
    protected String crearSQLActualizacion() {
        return "update cliente set codigo = ?, cedula = ?, nombre = ?, direccion = ?, telefono = ?, correo = ?, clasificación = ?, comentario = ? where codigo = ?";
    }

    @Override
    protected void cargarParametrosSQLActualizacion(PreparedStatement ps, Cliente dato) throws Exception {
        DBUtil.setInteger(ps, 1, dato.getcodigo());
        DBUtil.setString(ps, 2, dato.getcedula());
        DBUtil.setString(ps, 3, dato.getnombre());
        DBUtil.setString(ps, 4, dato.getdireccion());
        DBUtil.setString(ps, 5, dato.gettelefono());
        DBUtil.setString(ps, 6, dato.getcorreo());
        DBUtil.setString(ps, 7, dato.getclasificacion());
        DBUtil.setString(ps, 7, dato.getcomentario());
    }

    @Override
    public String getNombreTabla() {
        return "cliente";
    }

    public List<Cliente> buscar(Connection conn, String cedula, String nombre) {
        List<Cliente> lista = new ArrayList<>();
        cedula = cedula != null ? cedula : "";
        nombre = nombre != null ? nombre : "";
        String sql = "select * from " + getNombreTabla() + " where cedula like '%" + cedula + "%' and nombre like '%" + nombre + "%'";
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery(sql);
            String pk = getNombreCampoPK();
            while (rs.next()) {
                lista.add(cargar(rs.getInt(pk), conn));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            DBUtil.cerrar(rs);
            DBUtil.cerrar(ps);
        }
        return lista;
    }
    
    public List<Cliente> buscar(String cedula, String nombre) {
        Connection conn = DBUtil.crearConexion();
        List<Cliente> salida;
        salida = buscar(conn, cedula, nombre);
        DBUtil.cerrar(conn);
        return salida;
    }
}
