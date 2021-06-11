<?php

include "header.php";
include "libs/conectar.php";
include "menuVeiculos.php";

?>

				<!-- .col-md-3 end -->
			<div class="col-xs-12 col-sm-12 col-md-9">
				<div class="row">
			<?php
			$sql = "SELECT c.nome cor, m.nome marca, v.id, v.modelo, v.anomodelo, v.anofabricacao, v.valor, v.fotodestaque 
			from veiculo v inner join cor c on (c.id = v.cor_id) 
            inner join marca m on (m.id = v.marca_id) limit 12";
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
	
	<?php
	
	include "footer.php";
	?>