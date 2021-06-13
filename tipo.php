<?php

include "header.php";
include "menuVeiculos.php";

$tipo = $_GET['tipo'];
?>
<div class="col-xs-12 col-sm-12 col-md-9">
	<div class="row">
		<?php
		$sql = "SELECT c.nome cor, m.nome marca, v.id, v.modelo, v.anomodelo, v.anofabricacao, v.valor, v.fotodestaque, v.tipo 
			from veiculo v inner join cor c on (c.id = v.cor_id) 
            inner join marca m on (m.id = v.marca_id) where v.tipo = '{$tipo}'";
		//pdo -> prepare
		$consulta = $pdo->prepare($sql);
		//executar o comando sql
		$consulta->execute();
        echo "<h2 class='text-center text-uppercase'>$tipo</h2>";
		while ($dados = $consulta->fetch(PDO::FETCH_OBJ)) {
			include 'cardVeiculo.php';
		}
		?>
	</div>
</div>
<!-- .col-md-9 end -->
</div>
<!-- .row end -->
</div>
<!-- .container end -->
</section>
<!-- #blog end -->

<?php

include "footer.php";
?>