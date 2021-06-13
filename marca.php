<?php

include "header.php";
include "menuVeiculos.php";

$marca_id = $_GET['id'];
$sql = "SELECT * from marca where id = $marca_id";
//pdo -> prepare
$consulta = $pdo->prepare($sql);
//executar o comando sql
$consulta->execute();
$dados = $consulta->fetch(PDO::FETCH_OBJ);
$marca = $dados->nome;
?>
<div class="col-xs-12 col-sm-12 col-md-9">
	<div class="row">
		<?php
		$sql = "SELECT c.nome cor, m.nome marca, v.id, v.modelo, v.anomodelo, v.anofabricacao, v.valor, v.fotodestaque, v.tipo 
			from veiculo v inner join cor c on (c.id = v.cor_id) 
            inner join marca m on (m.id = v.marca_id) where m.id = {$marca_id}";
		//pdo -> prepare
		$consulta = $pdo->prepare($sql);
		//executar o comando sql
		$consulta->execute();
		echo "<h2 class='text-center text-uppercase'>$marca</h2>";
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