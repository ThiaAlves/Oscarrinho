	<br><br><br><br>
	<div class="cycle-slideshow">
		<img src="images/banner1.jpg" alt="Banner" title="Banner">
		<img src="images/banner2.jpg" alt="Banner">
		<img src="images/banner3.jpg" alt="Banner">
		<img src="images/banner4.jpg" alt="Banner" title="Banner">
	</div>

	<!-- Fim da sessao de slider -->
	<section id="shopgrid" class="">
		<div class="container">
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-3 sidebar">
				<div class="widget widget-categories">
						<div class="widget-title">
							<h5>Categoria</h5>
						</div>
						<div class="widget-content">
							<ul class="list-unstyled">
									<li>
										<?php
										 $ano = date('Y');
										 $sql = "SELECT count(anofabricacao) veiculos from veiculo where anofabricacao >= {$ano}";
										 //pdo -> prepare
										 $consulta = $pdo->prepare($sql);
										 //executar o comando sql
										 $consulta->execute();
										 $dados = $consulta->fetch(PDO::FETCH_OBJ)
										?>
										<a href="categoria.php?categoria=1"><i class="fa fa-angle-double-right"></i>Novo<span>(<?=$dados->veiculos ?>)</span></a>
									</li>
									<li>
										<?php
										 $ano = date('Y');
										 $sql = "SELECT count(anofabricacao) veiculos from veiculo where anofabricacao < {$ano}";
										 //pdo -> prepare
										 $consulta = $pdo->prepare($sql);
										 //executar o comando sql
										 $consulta->execute();
										 $dados = $consulta->fetch(PDO::FETCH_OBJ)
										?>
										<a href="categoria.php?categoria=2"><i class="fa fa-angle-double-right"></i>Seminovo<span>(<?=$dados->veiculos ?>)</span></a>
									</li>
							</ul>
						</div>
					</div>
					<div class="widget widget-categories">
						<div class="widget-title">
							<h5>Marcas</h5>
						</div>
						<div class="widget-content">
							<ul class="list-unstyled">
								<?php
								$sql = "SELECT m.nome marca, count(m.id) veiculos, m.id 
								from veiculo v 
								inner join marca m on (m.id = v.marca_id) where m.status = 1  
								group by m.id";
								//pdo -> prepare
								$consulta = $pdo->prepare($sql);
								//executar o comando sql
								$consulta->execute();
								while ($dados = $consulta->fetch(PDO::FETCH_OBJ)) {
								?>
									<li>
										<a href="marca.php?id=<?= $dados->id ?>"><i class="fa fa-angle-double-right"></i><?= $dados->marca ?><span>(<?= $dados->veiculos ?>)</span></a>
									</li>
								<?php
								}
								?>
							</ul>
						</div>
					</div>
					<div class="widget widget-categories">
						<div class="widget-title">
							<h5>Cores</h5>
						</div>
						<div class="widget-content">
							<ul class="list-unstyled">
								<?php
								$sql = "SELECT c.nome cor, count(c.id) veiculos, c.id 
								from veiculo v inner join cor c on (c.id = v.cor_id)
								where c.status = 1
								group by c.id ";
								//pdo -> prepare
								$consulta = $pdo->prepare($sql);
								//executar o comando sql
								$consulta->execute();
								while ($dados = $consulta->fetch(PDO::FETCH_OBJ)) {
								?>
									<li>
										<a href="cor.php?id=<?= $dados->id ?>"><i class="fa fa-angle-double-right"></i><?= $dados->cor ?><span>(<?= $dados->veiculos ?>)</span></a>
									</li>
								<?php
								}
								?>
							</ul>
						</div>
					</div>
					<div class="widget widget-categories">
						<div class="widget-title">
							<h5>Tipos</h5>
						</div>
						<div class="widget-content">
							<ul class="list-unstyled">
								<?php
								$sql = "SELECT v.tipo, count(v.tipo) veiculos
								from veiculo v
								group by v.tipo;";
								//pdo -> prepare
								$consulta = $pdo->prepare($sql);
								//executar o comando sql
								$consulta->execute();
								while ($dados = $consulta->fetch(PDO::FETCH_OBJ)) {
								?>
									<li>
										<a href="tipo.php?tipo=<?= $dados->tipo ?>"><i class="fa fa-angle-double-right"></i><?= $dados->tipo ?><span>(<?= $dados->veiculos ?>)</span></a>
									</li>
								<?php
								}
								?>
							</ul>
						</div>
					</div>
				</div>