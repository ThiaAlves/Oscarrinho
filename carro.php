<?php

include "header.php";
include "libs/conectar.php";

$id = $_GET['id'];

$sql = "SELECT c.nome cor, m.nome marca, v.modelo, v.anomodelo, v.anofabricacao, v.valor, v.fotodestaque, v.opcionais, v.tipo 
			from veiculo v inner join cor c on (c.id = v.cor_id) 
            inner join marca m on (m.id = v.marca_id) where v.id = {$id} limit 1";
            $consulta = $pdo->prepare($sql);
			//executar o comando sql
			$consulta->execute();
            $dados = $consulta->fetch(PDO::FETCH_OBJ);
?>
	
	<!-- Shop Single right sidebar
============================================= -->
	<section id="shopgrid" class="shop shop-single">
		<div class="container shop-content">
			<!-- .row end -->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-5">
					<div class="prodcut-images">
						<div class="product-img-slider">
							<img src="images/veiculos/<?=$dados->fotodestaque?>" alt="<?=$dados->modelo?>">
						</div>
					</div>
				</div>
				<div class="col-xs-12 col-sm-12 col-md-7">
					<div class="product-title text-center-xs">
						<h3><?=$dados->marca?>  - <?=$dados->modelo?></h3>
					</div>
					<!-- .product-title end -->
					<div class="product-meta mb-30">
						<div class="product-price pull-left pull-none-xs">
							<p>R$<?=number_format($dados->valor, 2, ",", ".")?></p>
						</div>
						<!-- .product-price end -->
						<div class="product-review text-right text-center-xs">
                            <br>
						</div>
						<!--- .product-review end -->
					</div>
					<!-- .product-img end -->
					
					<div class="product-desc text-center-xs">
					</div>
					<!-- .product-desc end -->
					
					<hr class="mt-30 mb-30">
					<div class="product-details text-center-xs">
						<h5>Detalhes  :</h5>
						<ul class="list-unstyled">
							<li>Fabricação : <span><?=$dados->anofabricacao?></span></li>
							<li>Modelo : <span><?=$dados->anomodelo?></span></li>
							<li>Tipo : <span><?=$dados->tipo?></span></li>
						</ul>
					</div>
					<!-- .product-details end -->
					<hr class="mt-30 mb-30">
					<!-- .product-share end -->
				</div>
			</div>
			<!-- .row end -->
			<div class="row">
				<div class="col-xs-12 col-sm-12 col-md-12">
					<div class="product-tabs">
						<!-- Nav tabs -->
						<ul class="nav nav-tabs" role="tablist">
							<li role="presentation" class="active">
								<a href="#description" aria-controls="description" role="tab" data-toggle="tab">Opcionais</a>
							</li>
						</ul>
						
						<!-- Tab panes -->
						<div class="tab-content">
							<div role="tabpanel" class="tab-pane active" id="description">
                            <table class="table table-striped">
									<tbody>
                                    <?php  
                                    $op = $dados->opcionais;
								    $opcionais= explode(".", $op);
                                    foreach ($opcionais as $opList) {
                                    ?>
                                    	<tr>
											<td><?=$opList?></td>
										</tr>
                                        <?php
                                    }
                                    ?>

									</tbody>
								</table>
							</div>
						</div>
						<!-- #tab-content end -->
					</div>
					<!-- .product-tabs end -->
				</div>
			</div>
			<!-- .row end -->
			<!-- Pager -->
            <hr>
			<!-- .row end -->
				<div class="row ">
			<?php
			$sql = "SELECT c.nome cor, m.nome marca, v.id, v.modelo, v.anomodelo, v.anofabricacao, v.valor, v.fotodestaque 
			from veiculo v inner join cor c on (c.id = v.cor_id) 
            inner join marca m on (m.id = v.marca_id) ORDER BY RAND( ) limit 3";
			//pdo -> prepare
			$consulta = $pdo->prepare($sql);
			//executar o comando sql
			$consulta->execute();
			while ( $dados = $consulta->fetch(PDO::FETCH_OBJ) ){
				?>		
						<div class="col-xs-12 col-sm-6 col-md-4 product">
							<div class="product-img">
								<img  src="images/veiculos/<?=$dados->fotodestaque?>" alt="<?=$dados->modelo?>"/>
								<div class="product-hover">
									<div class="product-action">
										<a class="btn btn-primary" href="carro.php?id=<?=$dados->id?>">Ver Detalhes</a>
									</div>
								</div>
								<!-- .product-overlay end -->
							</div>
								<!-- .product-img end -->
								<div class="product-bio">
								<div class="prodcut-cat">
									<a href="carro.php?id=<?=$dados->id?>"><?=$dados->marca?></a>
								</div>
								<!-- .product-cat end -->
								<div class="prodcut-title">
									<h3>
										<a href="carro.php?id=<?=$dados->id?>"><?=$dados->modelo?><p><?=$dados->anomodelo?>/<?=$dados->anofabricacao?></p></a>
									</h3>
								</div>
								<!-- .product-title end -->
								<div class="product-price">
									<span class="symbole">R$</span><span><?=number_format($dados->valor, 2, ",", ".")?></span>
								</div>
								<!-- .product-price end -->
								</div>
							<!-- .product-bio end -->
						</div>
						<!-- .product end -->
				<?php
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
	
	<!-- Footer #1
============================================= -->
	
<?php

include "footer.php";
?>